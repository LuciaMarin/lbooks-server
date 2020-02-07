package net.ausiasmarch.helper;

import net.ausiasmarch.setting.ConfigurationSettings;
import net.ausiasmarch.setting.ConfigurationSettings.EnvironmentConstans;

public class TraceHelper {

    public static void trace(String s) {
        if (ConfigurationSettings.environment == EnvironmentConstans.Debug) {
            System.out.println(s);
        }
    }
}
