package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */

    private static final HashSet<String> ACCESS_MODIFIERS = new HashSet<>(Arrays.asList("public", "protected", "private"));

    public MethodSignature parseFunction(String signatureString) {
        String[] parts = signatureString.split("[\\s(),]+");

        // Extract components from the split parts
        String accessModifier = null;
        String returnType;
        String methodName;
        int startIdx = 0;

        // Check if the first part is a valid access modifier
        if (ACCESS_MODIFIERS.contains(parts[0])) {
            accessModifier = parts[0];
            startIdx = 1;
        }

        returnType = parts[startIdx];
        methodName = parts[startIdx + 1];

        List<MethodSignature.Argument> arguments = new ArrayList<>();
        for (int i = startIdx + 2; i < parts.length - 1; i += 2) {
            String argType = parts[i];
            String argName = parts[i + 1];
            arguments.add(new MethodSignature.Argument(argType, argName));
        }

        // Create and return MethodSignature object
        return new MethodSignature(accessModifier, returnType, methodName, arguments);
    }


}
