package com.dlt.mbbtraining.mbbmasterdata.utils;

import com.dlt.mbbtraining.mbbmasterdata.utils.enums.EnvironmentRegion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * Created by Amir on 12/4/2019 10:59 PM
 */

@Slf4j
public class GlobalUtil {

    /**
     * ZONE ID FOR ASIA/KUALA LUMPUR
     */
    public final static ZoneId MY_ZONE_ID = ZoneId.of("Asia/Kuala_Lumpur");

    /**
     * ZONE ID FOR ASIA/SINGAPORE*
     */
    public final static ZoneId SG_ZONE_ID = ZoneId.of("Asia/Singapore");

    /**
     * @param input string value
     * @return string with removed whitespace and all uppercase
     * @NotNull method not return to null
     */
    @NotNull
    public static String removeWhiteSpaceAndMakeitCapital(String input) {
        return input.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("[\\s\\-()]", "")
                .toUpperCase(Locale.ROOT);
    }

    /**
     * @return current timestamp for MY IN ISO8601
     * @NotNull method not return to null
     */
    @NotNull
    public static String currentMalaysiaTimestampIso8601() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(MY_ZONE_ID));
        return simpleDateFormat.format(new Date());
    }

    /**
     * @return current timestamp for SG IN ISO8601
     * @NotNull method not return to null
     */
    public static String currentSingaporeTimestampIso8601() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(SG_ZONE_ID));
        return simpleDateFormat.format(new Date());
    }

    /**
     * UTIL TO COPY THE PROPERTIES FROM SOURCE OF CLASS TO TARGET OF CLASS
     *
     * @param source origin of the object
     * @param target of the object
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void copyProperties(Object source, Object target) throws IllegalAccessException,
            InvocationTargetException {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * Find region match API path by given the API
     *
     * @param input the path of string
     * @return whether the path is coming from which region
     */
    public String findRegionMatchAPiPath(@NotNull String input) {
        input = input.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("[\\s\\-()]", "")
                .toUpperCase(Locale.ROOT);

        AtomicReference<String> result = new AtomicReference<>();
        String finalInput = input;
        Stream.of(EnvironmentRegion.values())
                .map(Enum::name)
                .forEach(x -> {
                    if (finalInput.contains(x)) {
                        log.info("X: {}", x);
                        result.set(x.toUpperCase(Locale.ROOT));
                    }
                });

        return result.get();
    }


}
