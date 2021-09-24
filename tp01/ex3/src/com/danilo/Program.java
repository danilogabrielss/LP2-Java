package com.danilo;

public class Program {
    public static void main(String[] args) {
        Student std = new Student("Danilo",
                "R. Parana,314",
                "Java",2021,22.22);
        System.out.println(std.toString());
        std.setProgram("Fall");
        System.out.println(std.getProgram());
        std.setFee(20.21);
        System.out.println(std.getFee());
        std.setYear(2050);
        System.out.println(std.getYear());
        System.out.println(std.getName());
        std.setAddress("R. Catiapoa,700");
        System.out.println(std.getAddress());
        System.out.println(std.toString());

        Staff staff = new Staff("Irineu","Rua Lobo Viana, 12",
                "Zulmira", 599.99);
        System.out.println(staff.toString());
        staff.setAddress("Rua Finados, 900");
        staff.setPay(4.29);
        staff.setSchool("SESI");
        System.out.println(staff.getName());
        System.out.println(staff.getAddress());
        System.out.println(staff.getPay());
        System.out.println(staff.getSchool());
        System.out.println(staff.toString());

    }
}
