package com.main.blog;


class Super {
    static String greeting() {
        return "Goodnight";
    }

    String name() {
        return "Richard";
    }
}

class Sub extends Super {
    static String greeting() {
        return "Hello";
    }

    String name() {
        return "Ashish";
    }
}

public class StaticOverrridding {

    public static void main(String[] args) {
        Super s = new Sub();
        System.out.println(s.greeting() + ", " + s.name());


//		Point p = new SlowPoint();
//		p.move(2, 4);


    }

}


class Point1 {
    int x = 0, y = 0;

    void move(int dx, int dy) {
        System.out.println("Point: move");
    }
}
//class SlowPoint extends Point {
//    int xLimit, yLimit;
//    void move(int dx, int dy) {
//      //  super.move(dx, dy);
//        System.out.println("SlowPoint: move");
//    }
//    
//}

