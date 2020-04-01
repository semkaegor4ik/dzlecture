package com.company;

public class Main {

    public static void main(String[] args) {
	    OurList list = new OurList();
        list.add("Egor","Semenov","male",19);
        list.add("Andrey","Kurochkin","male",19);
        list.add("Maxim","Semenov","male",26);
        list.add("Anna","Gryaznova","female",19);
        list.add("Victor","Dorodnov","male",30);
        list.add("Anastasia","Dorodnova","female",26);
        System.out.println(list.size());
        list.show();
        list.remove(3);
        System.out.println(list.size());
        list.show();
        list.remove("Andrey","Kurochkin","male",19);
        System.out.println(list.size());
        list.show();
        list.add(3,"Andrey","Kurochkin","male",19);
        System.out.println(list.size());
        list.show();
        System.out.println(list.indexOf("Victor","Dorodnov","male",30));
        System.out.println(list.get(1));
        list.clear();
        System.out.println(list.size());
        list.show();
    }
}
