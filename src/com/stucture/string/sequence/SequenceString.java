package com.stucture.string.sequence;

public class SequenceString {
    private char[] str;
    private int length;

    private void init(int max_num) {
        this.str = new char[max_num + 1];
        this.length = 0;
    }

    /**
     * 赋值
     *
     * @param ch
     */
    private void assign(char[] ch) {
        this.str = new char[ch.length + 1];
        for (int i = 0; i < ch.length; i++) {
            this.str[i] = ch[i];
        }
        this.str[ch.length] = '\0';
        this.length = ch.length;
    }

    /**
     * 赋值
     *
     * @param s
     */
    private void assign(SequenceString s) {
        this.str = new char[s.length + 1];
        for (int i = 0; i < s.length; i++) {
            this.str[i] = s.str[i];
        }
        this.str[s.length] = '\0';
        this.length = s.length;
    }

    /**
     * 拼接字符串
     *
     * @param ch
     */
    private void concat(char[] ch) {
        SequenceString str = new SequenceString();
        str.assign(this.str);
        this.str = new char[ch.length + this.length + 1];
        for (int i = 0; i < this.length; i++) {
            this.str[i] = str.str[i];
        }
        for (int i = 0; i < ch.length; i++) {
            this.str[i + this.length] = ch[i];
        }
        this.length = this.length + ch.length;
        this.str[this.length] = '\0';
    }

    /**
     * 求子串
     *
     * @param start
     * @param len
     * @return
     */
    private SequenceString subStr(int start, int len) {
        SequenceString str = new SequenceString();
        if (start < 1 || start > this.length || isNull() || len > this.length - start + 1) {
            str.init(0);
            return str;
        }
        str.init(this.length);
        for (int i = 0; i < len; i++) {
            str.str[i] = this.str[i + (start - 1)];
        }
        return str;
    }

    /**
     * 定位
     * @param ch
     * @return
     */
    private int index(char[] ch) {
        int i = 0;
        int j = 0;
        while (i < this.length&& j< ch.length) {
            if (this.str[i] == ch[j]) {
                i ++;
                j ++;
            } else {
                i =i -j +1;
                j = 0;
            }
        }
        if(j == ch.length) {
            return i - ch.length + 1;
        }
        return 0;
    }

    /**
     * 判断是否为空串
     * @return
     */
    private boolean isNull(){
        if (this.length ==0) {
            return true;
        }
        return false;
    }
}
