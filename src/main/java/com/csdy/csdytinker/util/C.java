package com.csdy.csdytinker.util;

import net.minecraft.ChatFormatting;

public class C {
    public static int bc ;
    private static final ChatFormatting[] color ={
            ChatFormatting.DARK_BLUE,
            ChatFormatting.AQUA,
            ChatFormatting.BLUE,
            ChatFormatting.DARK_AQUA,
            ChatFormatting.DARK_GREEN,
            ChatFormatting.DARK_PURPLE,
            ChatFormatting.GOLD,
            ChatFormatting.DARK_RED,
            ChatFormatting.YELLOW,
            ChatFormatting.RED,
            ChatFormatting.GREEN,
            ChatFormatting.LIGHT_PURPLE
    };

    public static String formatting(String input, ChatFormatting[] colours, double delay) {
        StringBuilder sb = new StringBuilder(input.length() * 1000);
        if (delay <= 0.2D)
            delay = 0.9999D;
        int offset = (int)Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(colours[(colours.length + i - offset) % colours.length].toString());
            sb.append(c);
            bc = i;
        }
        return sb.toString();
    }

    public static String GetColor(String input) {
        return formatting(input, color, 80.0D);
        //                  ^      ^     ^
        //               输入文本  颜色  延迟
    }

}

