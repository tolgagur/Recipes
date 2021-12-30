class Complex {

    double real;
    double image;

    // write methods here
    
    void add(Complex anotherNum) {
        real = real + anotherNum.real;
        this.image = this.image + anotherNum.image;
        //System.out.printf("number = %.1f + %.1fi", this.real, this.image);
    }

    void subtract(Complex anotherNum) {
        real = real - anotherNum.real;
        this.image = this.image - anotherNum.image;
        //System.out.printf("\nnumber = %.1f - %.1fi", this.real, this.image);
    }
}
