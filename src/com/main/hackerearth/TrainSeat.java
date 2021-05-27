package com.main.hackerearth;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;

public class TrainSeat {

    public static void main(String args[]) throws Exception {
        DataInputStream dis = new DataInputStream(System.in);
        Reader reader = new Reader(dis);
        int seatBatch = 6;
        String[] seatName = {"", "WS", "MS", "AS", "AS", "MS", "WS"};
        int[] opp = new int[109];
        String[] seatType = new String[109];
        int main = 11;
        boolean rev = false;
        char newLine = '\n';
        char space = ' ';
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 108; i++) {
            if (!rev) {
                opp[i] = i + main;
                if (main > 1) {
                    main = main - 2;
                }
            } else {
                opp[i] = i - main;
                if (main < 11) {
                    main = main + 2;
                }
            }
            if (i % seatBatch == 0) {
                rev = !rev;
                seatType[i] = seatName[6];
            } else {
                seatType[i] = seatName[i % 6];
            }
        }
        int arrarySize = reader.nextInt();
        for (int i = 0; i < arrarySize; i++) {
            int num = reader.nextInt();
            str.append(opp[num]);
            str.append(space);
            str.append(seatType[num]);
            str.append(newLine);
        }
        System.out.println(str.toString());

    }


    static class Reader {

        private DataInputStream dis = null;
        private int bufferSize = 1 << 24;
        private byte[] by = new byte[bufferSize];
        private int read = 0;
        private int count = 0;
        private int index = -1;

        Reader() {
        }

        Reader(DataInputStream is) {
            this.dis = is;
        }

        private boolean loadBuffer() throws IOException {
            while ((read = dis.read(by)) != -1) {
                return true;
            }
            return false;
        }

        private int readCharAsInt() throws IOException {
            if (index < 0 || index >= read)
                if (loadBuffer())
                    index = 0;
                else
                    return -1;
            if (index < read) {
                int temp = index;
                index++;
                if (by[temp] != 0) {
                    return by[temp];
                } else
                    return -1;
            }
            return -1;
        }

        public int nextInt() throws IOException {
            int temp = 0;
            int num = 0;
            boolean status = false;

            while ((temp = readCharAsInt()) != -1) {
                if (temp >= 48 && temp <= 57) {
                    num = temp - 48;
                    status = true;
                    break;
                }
            }

            while ((temp = readCharAsInt()) != -1) {
                if (temp >= 48 && temp <= 57)
                    num = temp - 48 + num * 10;
                else
                    break;
            }

            if (status)
                return num;

            return -1;
        }
    }

    static class Writer {

        BufferedWriter wr = null;

        Writer() {
        }

        public Writer(BufferedWriter wr) {
            this.wr = wr;
        }

        public void write(int value) throws IOException {
            wr.write(value + " ");
        }

        public void flush() throws IOException {
            wr.flush();
            wr.close();
        }
    }

}
