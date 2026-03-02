#include <iostream>
#include <string.h>
using namespace std;
class Car{
    //implicit constructor
    protected:
        int number_of_seats;
        char* brand;
    public:
        Car(){
            this->number_of_seats=0;
            this->brand=new char[strlen("default")+1];
            strcpy(this->brand,"default");
        };
        Car(int number_of_seats, char* brand){
            this->number_of_seats=number_of_seats;
            this->brand=new char[strlen(brand)+1];
            strcpy(this->brand,brand);
        }

        //mutators
        void set_Seats(int number_of_seats){
            this->number_of_seats=number_of_seats;
        }
        void set_Brand(char* brand){
            this->brand=new char[strlen(brand)+1];
            strcpy(this->brand, brand);
        }

        //accesors
        char* getBrand(void){
            return this->brand;
        }
        int getSeats(void){
            return this->number_of_seats;
        }
        void print(){
            cout<<"Name: "<<this->brand<<"\n";
            cout<<"Seats: "<<this->number_of_seats<<"\n";
        }
        friend ostream& operator<<(ostream &out, const Car& c);
        friend istream& operator>>(istream &in, Car&c);

};

ostream& operator<<(ostream &out, const Car& c){
    out<<"Car named: "<<c.brand<<" has "<<c.number_of_seats<<" seats";
    return out;
}
istream& operator>>(istream& in, Car&c){
    in>>c.number_of_seats;
    char brand[100];
    in>>brand;
    c.set_Brand(brand);
    return in;
}
class EvolvedCar: public Car{
    private: 
        int capacity;
    public:
        void setCapacity(int capacity){
            this->capacity=capacity;
        }
        int getCapacity(void){
            return this->capacity;
        }
        void print(){
            Car::print();

            cout<<"The capacity is: "<<capacity;
        }
        friend ostream& operator<<(ostream &out, const EvolvedCar& c);
        friend istream& operator>>(istream &in, EvolvedCar&c);
};

ostream& operator<<(ostream &out, const EvolvedCar& c){
    out<<"Car named: "<<c.brand<<" has "<<c.number_of_seats<<" seats and has the capacity: "<<c.capacity;
    return out;
}
istream& operator>>(istream &in, EvolvedCar&c){
    in>>c.number_of_seats;
    char brand[100];
    in>>brand;
    c.set_Brand(brand);
    in>>c.capacity;
    return in;
}