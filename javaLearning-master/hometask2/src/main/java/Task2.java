public class Task2 {
    public static void main(String[] args) {
//        1

        int[] array1 = {1, 2, 3, 4, 5, 10, 8};
        for (int i1 = 0; i1 < array1.length; i1++) {
            for (int j1 = 0; j1 < (array1.length - 1); j1++) {
                if (array1[j1] <= array1[j1 + 1]) {
                    int max1 = array1[j1 + 1];
                    int min1 = array1[j1];
                    array1[j1 + 1] = min1;
                    array1[j1] = max1;

                }
            }
        }
        System.out.println("1. ");
        for (int temp1 : array1) {
            System.out.println("     " + temp1);
        }

//        2

        int[] array2 = {1, 2, 3, 4, 5};
        int sum2 = 0;
        for (int i2 = 0; i2 < array2.length; i2++) {
            sum2 = sum2 + array2[i2];
        }
        System.out.print("2. sum2=" + sum2);
        System.out.println();

//        3

        char[] array3 = new char[10];
        for (int a3 = 0; a3 < array3.length; a3++) {
            array3[a3] = '-';
        }
        System.out.println("3. ");
        for (int b3 = 0; b3 <= 5; b3++) {

            for (char c3 : array3) {
                System.out.print(c3);
            }
            System.out.println();
        }

//        4

        int[] array4 = {1, 2, 36, 99, 5};
        int sum4 = 0;
        for (int j4 = 0; j4 < array4.length; j4++) {
            sum4 = sum4 + array4[j4];
        }
        double average4 = sum4 / array4.length;
        System.out.print("4. average=" + average4);
        System.out.println();

//        5

        int[] array5 = {1, 99, 36, 99, 5};
        int findvalue5 = 99;
        for (int i5 = 0; i5 < array5.length; i5++) {
            if (array5[i5] == findvalue5) {
                System.out.printf("5. Desired element %d has number %d", findvalue5, i5 + 1);
                System.out.println();
            }
        }

//        6

        int[] array6 = {1, 99, 36, 99, 5};
        int findvalue6 = 36;
        for (int i6 = 0; i6 < array6.length; i6++) {
            if (array6[i6] == findvalue6) {
                System.out.printf("6. Desired element %d has number %d", findvalue6, i6 + 1);
                System.out.println();
            }
        }

//        7

        char[] array7 = {'a', 'b', 'c', 'e', 'f'};
        char removeValue7 = 'b';
        char empty7 = '_';
        for (int i7 = 0; i7 < array7.length; i7++) {
            if (array7[i7] == removeValue7) {
                array7[i7] = empty7;
            }
        }

        System.out.println("7. " + new String(array7));

//        8

        char[] copy8From = {'a', 'b', 'c', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'};
        char[] copy8To = new char[copy8From.length];
        for (int i8 = 0; i8 < copy8From.length; i8++) {
            System.arraycopy(copy8From, i8, copy8To, i8, 1);
        }
        System.out.println("8. Copied array - " + new String(copy8To));

//        9

        char[] array9 = {'a', 'b', 'c', 'e', 'f'};
        int position9 = 3;
        char insertValue9 = 'A';
        for (int i9 = 0; i9 < array9.length; i9++) {
            if (i9 == position9 - 1) {
                array9[i9] = insertValue9;
            }
        }
        System.out.println("9. " + new String(array9));


//        10

        int max10 = 0;
        int min10 = 9999;
        int[] array10 = {1, 2, 3, 4, 5, 10, 8};
        for (int i10 = 0; i10 < array10.length; i10++) {
            if (array10[i10] <= min10) {
                min10 = array10[i10];
            }
        }
        for (int i10 = 0; i10 < array10.length; i10++) {
            if (array10[i10] >= max10) {
                max10 = array10[i10];
            }
        }
        System.out.println("10. max value - " + max10);
        System.out.println("10. min value - " + min10);

//        11

        int[] array11 = {1, 2, 3, 4, 5, 10, 8};
        int[] arrayreverse11 = new int[array11.length];
        for (int i11 = 0; i11 < array11.length; i11++) {
            arrayreverse11[array11.length - 1 - i11] = array11[i11];
        }
        System.out.println("11. Reverse array - ");
        for (int temp11 : arrayreverse11) {
            System.out.print(temp11 + " ");
        }
        System.out.println();

//        12

        int[] array12 = {1, 2, 3, 4, 2, 3,};
        for (int i12 = 0; i12 < array12.length; i12++) {
            for (int j12 = 0; j12 < array12.length; j12++) {
                if (array12[i12] == array12[j12] && i12 != j12 && i12 < j12) {
                    System.out.printf("12. Same elements -  %d and %d ", i12 + 1, j12 + 1);
                    System.out.println();
                }
            }
        }
        System.out.println();

//        13

        String[] array13 = {"a", "b", "c", "d", "e", "c",};
        for (int i13 = 0; i13 < array13.length; i13++) {
            for (int j13 = 0; j13 < array13.length; j13++) {
                if (array13[i13] == array13[j13] && i13 != j13 && i13 < j13) {
                    System.out.printf("13. Same elements -  %d and %d ", i13 + 1, j13 + 1);
                    System.out.println();
                }
            }
        }
        System.out.println();


//        14

        String[] array14 = {"a", "b", "c", "d", "e", "c",};
        String[] secarray14 = {"и", "м", "d", "c", "f", "i",};
        for (int i14 = 0; i14 < array14.length; i14++) {
            for (int j14 = 0; j14 < secarray14.length; j14++) {
                if (array14[i14] == secarray14[j14]) {
                    System.out.printf("14. Same elements -  %d (1 array) and %d (2 array) ", i14 + 1, j14 + 1);
                    System.out.println();
                }
            }
        }
        System.out.println();

//        15

        int[] array15 = {1, 24, 3, 4, 2, 3,};
        int[] secarray15 = {12, 23, 42, 44, 24, 31,};

        for (int i15 = 0; i15 < array15.length; i15++) {
            for (int j15 = 0; j15 < secarray15.length; j15++) {
                if (array15[i15] == secarray15[j15]) {
                    System.out.printf("15. Same elements -  %d (1 array) and %d (2 array) ", i15 + 1, j15 + 1);
                    System.out.println();
                }
            }
        }
        System.out.println();

//        16

        String[] array16 = {"a", "b", "c", "d", "e", "c", "f"};
        String a16 = " ";
        System.out.print("16. Start array   - ");
        for (int i16 = 0; i16 < array16.length; i16++) {
            System.out.print(array16[i16]);
        }
        System.out.println();
        for (int i16 = 0; i16 < array16.length; i16++) {
            for (int j16 = 0; j16 < array16.length; j16++) {
                if (array16[i16] == array16[j16] && i16 != j16 && i16 < j16) {
                    array16[i16] = a16;
                    array16[j16] = a16;
                }
            }
        }
        System.out.print("16. Changed array - ");
        for (int i16 = 0; i16 < array16.length; i16++) {
            System.out.print(array16[i16]);
        }
        System.out.println();

//        17

        int max17 = 0;
        int secondmax17 = 0;
        int[] array17 = {1, 2, 3, 4, 5, 10, 8};
        for (int i17 = 0; i17 < array17.length; i17++) {
            if (array17[i17] >= max17) {
                max17 = array17[i17];
            }
        }
        for (int i17 = 0; i17 < array17.length; i17++) {
            if (array17[i17] >= secondmax17 && array17[i17] != max17) {
                secondmax17 = array17[i17];
            }
        }
        System.out.println("17. Second max value - " + secondmax17);


//        18

        int min18 = 9999;
        int secondmin18 = 9990;
        int[] array18 = {1, 2, 3, 4, 5, 10, 8};
        for (int i18 = 0; i18 < array17.length; i18++) {
            if (array18[i18] <= min18) {
                min18 = array17[i18];
            }
        }
        for (int i18 = 0; i18 < array18.length; i18++) {
            if (array18[i18] <= secondmin18 && array18[i18] != min18) {
                secondmin18 = array18[i18];
            }
        }
        System.out.println("18. Second min value - " + secondmin18);


//        19

        int[][] array19 = {{1, 2, 3, 4, 5},
                {10, 8, 20, 31, 12, 34}};
        int a19 = array19.length;
        int b19 = array19[0].length;

        int[][] arrayrfirstadd19 = new int[a19][b19];
        int[][] arrayrsecondadd19 = new int[a19][b19];

        System.out.println("19. ");

        for (int i19 = 0; i19 < a19; i19++) {
            for (int j19 = 0; j19 < b19; j19++) {
                System.out.print(arrayrfirstadd19[i19][j19] + " ");

            }
            System.out.println();
        }
        System.out.println();

        for (int i19 = 0; i19 < a19; i19++) {
            for (int j19 = 0; j19 < b19; j19++) {
                System.out.print(arrayrsecondadd19[i19][j19] + " ");

            }
            System.out.println();
        }
    }
}

