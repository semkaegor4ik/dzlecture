package com.company;

import java.util.*;

public class OurList{


    private int arraySize = 16;
    private Human[] array = new Human[arraySize];
    private int size = 0;
    public OurList() {}

    private class Human{
        private final String name;
        private final String surname;
        private final String gender;
        private final int age;

        public Human(String name, String surname, String gender, int age) {
            this.name = name;
            this.surname = surname;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return age == human.age &&
                    name.equals(human.name) &&
                    surname.equals(human.surname) &&
                    gender.equals(human.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, gender, age);
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }

    public Object[] toArray() {
        if(size!=0) {
            Object[] newArray = new Human[arraySize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            return newArray;
        }
        return null;
    }

    public boolean add(String name, String surname, String gender, int age) {
        Human o = new Human(name, surname, gender, age);
        if(size<arraySize) {
            array[size] = o;
        }
        else{
            arraySize*=2;
            Human[] newArray = new Human[arraySize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            array[size] = o;
        }
        size++;
        return true;
    }

    public boolean remove(String name, String surname, String gender, int age) {
        Human o = new Human(name, surname, gender, age);
        if(size == 0)
            return false;
        Human[] newArray = new Human[arraySize];
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < size ; i++) {
            if(array[i].equals(o)){
                flag = true;
            }
            else{
                newArray[index]= array[i];
                index++;
            }
        }
        array = newArray;
        size--;
        return flag;
    }

    public void clear() {
        size = 0;
        arraySize = 16;
        array = new Human[arraySize];
    }

    public Human get(int index) {
        if(index>=size)
            return null;
        return array[index];
    }

    public boolean add(int index, String name, String surname, String gender, int age) {
        Human element = new Human(name, surname, gender, age);
        if((index>size)||(index<0)){
            return false;
        }
        if(size==arraySize){
            arraySize*=2;
        }
        Human[] newArray =new Human[arraySize];
        for (int i = 0; i <index ; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index+1; i <size+1 ; i++) {
            newArray[i] = array[i-1];
        }
        array = newArray;
        size++;
        return true;
    }

    public Human remove(int index) {
        if((index>size)||(index<0)){
            return null;
        }
        Human[] newArray =new Human[arraySize];
        for (int i = 0; i <index ; i++) {
            newArray[i] = array[i];
        }
        for (int i = index+1; i <size ; i++) {
            newArray[i-1] = array[i];
        }
        size--;
        Human ask = array[index];
        array = newArray;
        return ask;
    }

    public int indexOf(String name, String surname, String gender, int age) {
        Human o = new Human(name, surname, gender, age);
        for (int i = 0; i < size; i++) {
            if(array[i].equals(o))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(String name, String surname, String gender, int age) {
        Human o = new Human(name, surname, gender, age);
        for (int i = size-1; i >= 0; i--) {
            if(array[i].equals(o))
                return i;
        }
        return -1;
    }

    public void show(){
        if(size==0) {
            System.out.println("List is empty");
        }
        else {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
