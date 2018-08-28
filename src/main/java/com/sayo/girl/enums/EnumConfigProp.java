package com.sayo.girl.enums;

public class EnumConfigProp {

    public static enum Gender {
        Female("F"),Male("M");

        private final String gender;

        private Gender(String s) {
            gender = s;
        }

        public String toString() {
            return gender;
        }
    }
}
