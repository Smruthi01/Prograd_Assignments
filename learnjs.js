// obj creation using literal
let student = {
    Name:"SMRUTHI",
    Age:"20",

    getInfo : function(){
        return('Name is ${student.Name}')
    },

    others : {
        marks:"90",
        grade:"a"
    }
   
}
console.log(student.getInfo);
console.log(student.others.marks);

//obj usimng constructor

function student(name,age){
    this.name = name;
    this.age = age;

}

let stud1= new student('priya','20');
let stud2= new student('shreya','21');

console.log(stud1.age);
console.log('${stud2.age},${stud1.name}');

//js has no classes using 
// no such access modifiers in JavaScript 
class Stud{
    constructor(name,age,marks){
        this.name = name;
        this.age = age;
        this.marks=marks;
    }
    getStud(){
        return('The name of student is ${this.name} whose marks is ${this.marks}')
    }
}
let Stud1 = new Stud("Raj","23","94") ;
let Stud2= new Stud("Devi","18","90");

console.log(Stud1.getStud);