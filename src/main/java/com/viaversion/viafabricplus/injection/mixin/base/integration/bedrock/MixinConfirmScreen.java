/*
 * This file is part of ViaFabricPlus - https://github.com/ViaVersion/ViaFabricPlus
 * Copyright (C) 2021-2025 the original authors
 *                         - FlorianMichael/EnZaXD <florian.michael07@gmail.com>
 *                         - RK_01/RaphiMC
 * Copyright (C) 2023-2025 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.viaversion.viafabricplus.injection.mixin.base.integration.bedrock;

import com.viaversion.viafabricplus.injection.access.base.bedrock.IConfirmScreen;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.MultilineTextWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ConfirmScreen.class)
public abstract class MixinConfirmScreen extends Screen implements IConfirmScreen {

    public MixinConfirmScreen(final Text title) {
        super(title);
    }

    @Override
    public void viaFabricPlus$updateMessage(Text message) {
        for (final Element element : children()) {
            if (element instanceof final MultilineTextWidget textWidget) {
                textWidget.setMessage(message);
                refreshWidgetPositions();
            }
        }
    }

}
