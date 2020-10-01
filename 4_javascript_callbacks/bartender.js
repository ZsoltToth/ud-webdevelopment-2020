
var calculateAge = (birthDate) => {
    return (Date.now() - Date.parse(birthDate)) / 1000 / 60 / 60/ 24 / 365;
}

var provideService = (customer) =>{
    calculateAge(customer.birthDate) >= 18 ? 
        alert(`Server ${customer.name}`) : 
        alert(`${customer.name} is too young!`);
}