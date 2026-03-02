#include "class.hpp"
int main(){
    char name[]="Aston";
    Car car1(5, name);
    cout<<"Class created\n";
    car1.print();
    
    EvolvedCar car2;
    cout<<"Enter seats and brand: ";
    cin>>car2;
    cout<<car2<<"\n";
    return 0;
}