package myproject.samples;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CrunchifyJoinArrays3Ways {

    public static void main(String[] args) {
        crunchifyPrint("Original String Array1: [google, twitter]");
        crunchifyPrint("Original String Array2: [apple, microsoft]");
        crunchifyPrint("Original Integer Array1: [111, 444]");
        crunchifyPrint("Original Integer Array2: [222, 555]\n");
        // Join Array using Apache Common utility
        //joinArrayUsingApacheCommon();
        // Join Array using Java8 Stream operation
        joinArrayUsingJava8Stream();
        // Join Array using Standard Java APIs
        joinArrayUsingJavaAPI();
    }
    // Method-1: Join Array using Apache Common utility
//    private static void joinArrayUsingApacheCommon() {
//        String[] company1 = new String[]{"google", "twitter"};
//        String[] company2 = new String[]{"apple", "microsoft"};
//        // from org.apache.commons.lang3 maven dependency
//        String[] crunchifyResult = ArrayUtils.addAll(company1, company2);
//        crunchifyPrint("From Method-1: addAll() - String ==> " + Arrays.toString(crunchifyResult));
//        int[] crunchifyArray1 = new int[]{111, 444};
//        int[] crunchifyArray2 = new int[]{222, 555};
//        int[] crunchifyResult2 = ArrayUtils.addAll(crunchifyArray1, crunchifyArray2);
//        crunchifyPrint("From Method-1: addAll() - Integer ==> " + Arrays.toString(crunchifyResult2));
//    }
    // Simple Java Print Method
    private static void crunchifyPrint(String result) {
        System.out.println(result);
    }
    // Method-2: Join Array using Java8 Stream operation
    private static void joinArrayUsingJava8Stream() {
        String[] company1 = new String[]{"google", "twitter"};
        String[] company2 = new String[]{"apple", "microsoft"};
        // Stream.of() - returns a sequential ordered stream whose elements are the specified values.
        // A sequence of elements supporting sequential and parallel aggregate operations. The following example illustrates an aggregate operation using Stream and IntStream:
        //
        //     int sum = widgets.stream()
        //                      .filter(w -> w.getColor() == RED)
        //                      .mapToInt(w -> w.getWeight())
        //                      .sum();
        String[] result = Stream.of(company1, company2).flatMap(Stream::of).toArray(String[]::new);
        String[] result1 = Stream.concat(Arrays.stream(company1), Arrays.stream(company2)).toArray(String[]::new);

        crunchifyPrint("\nFrom Method-2: Stream.of() ==> " + Arrays.toString(result));
        crunchifyPrint("\nFrom Method-2: Stream.concat() ==> " + Arrays.toString(result1));

        int[] crunchifyArray1 = new int[]{111, 444};
        int[] crunchifyArray2 = new int[]{222, 555};
        // Arrays.stream() - returns a sequential IntStream with the specified array as its source.
        int[] crunchifyResult2 = IntStream.concat(Arrays.stream(crunchifyArray1), Arrays.stream(crunchifyArray2)).toArray();
        crunchifyPrint("From Method-2: IntStream.concat() ==> " + Arrays.toString(crunchifyResult2));
    }
    // Method-3: Join Array using Standard Java APIs
    private static void joinArrayUsingJavaAPI() {
        String[] company1 = new String[]{"google", "twitter"};
        String[] company2 = new String[]{"apple", "microsoft"};
        String[] crunchifyResult = crunchifyJoinGenericArray(company1, company2);
        crunchifyPrint("\nFrom Method-3: crunchifyJoinArrayusingGeneric() ==> " + Arrays.toString(crunchifyResult));
        int[] crunchifyArray1 = new int[]{111, 444};
        int[] crunchifyArray2 = new int[]{222, 555};
        int[] crunchifyResult2 = crunchifyJoinIntegerArray(crunchifyArray1, crunchifyArray2);
        // Arrays.toString() Returns a string representation of the contents of the specified array.
        // The string representation consists of a list of the array's elements, enclosed in square brackets ("[]").
        // Adjacent elements are separated by the characters ", " (a comma followed by a space).
        // Elements are converted to strings as by String.valueOf(int). Returns "null" if a is null.
        crunchifyPrint("From Method-3: joinArray() ==> " + Arrays.toString(crunchifyResult2));
    }
    @SafeVarargs
    private static <T> T[] crunchifyJoinGenericArray(T[]... crunchifyArrays) {
        int crunchify = 0;
        for (T[] crunchifyArray : crunchifyArrays) {
            crunchify += crunchifyArray.length;
        }
        //T[] result = new T[crunchify];
        final T[] crunchifyResult = (T[]) Array.newInstance(crunchifyArrays[0].getClass().getComponentType(),
                crunchify);
        int crunchifyOffset = 0;
        for (T[] crunchifyArray : crunchifyArrays) {
            // Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
            // A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest.
            // The number of components copied is equal to the length argument.
            // The components at positions srcPos through srcPos+length-1 in the source array are copied into positions destPos through destPos+length-1, respectively, of the destination array.
            System.arraycopy(crunchifyArray, 0, crunchifyResult, crunchifyOffset, crunchifyArray.length);
            crunchifyOffset += crunchifyArray.length;
        }
        return crunchifyResult;
    }
    private static int[] crunchifyJoinIntegerArray(int[]... crunchifyArrays) {
        int crunchify = 0;
        for (int[] crunchifyArray : crunchifyArrays) {
            crunchify += crunchifyArray.length;
        }
        final int[] crunchifyResult = new int[crunchify];
        int crunchifyOffset = 0;
        for (int[] crunchifyArray : crunchifyArrays) {
            System.arraycopy(crunchifyArray, 0, crunchifyResult, crunchifyOffset, crunchifyArray.length);
            crunchifyOffset += crunchifyArray.length;
        }
        return crunchifyResult;
    }
}
