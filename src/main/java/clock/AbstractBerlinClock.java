package main.java.clock;

import main.java.builder.LampsBuilder;
import main.java.helpers.LampSwitchManager;

/**
 * Created by raval on 2017-10-06.
 */
public abstract class AbstractBerlinClock {

    abstract String switchLampsFor(Integer position, Integer lampsToSwitch);

    String switchOnLamps(Integer lapmsOn, Integer lampsSize) {
        LampsBuilder.Builder lampsBuilder = new LampsBuilder.Builder();
        for(int position = 1; position <= lampsSize; position++) {
            lampsBuilder.appendLamps(
                    switchLampsFor(position, lapmsOn)
            );
        }
        return lampsBuilder.build().getLamps();
    }

    String switchOnBottomLamps(Integer bottomOnLamps, Integer lampsSize) {
        LampsBuilder.Builder lampsBuilder = new LampsBuilder.Builder();
        for(int position = 1; position <= lampsSize; position++) {
            lampsBuilder.appendLamps(
                    LampSwitchManager.switchBottomLampsForMinutes(position, bottomOnLamps)
            );
        }
        return lampsBuilder.build().getLamps();
    }
}