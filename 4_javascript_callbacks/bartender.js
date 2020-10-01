
var calculateAge = (birthDate) => {
    return (Date.now() - Date.parse(birthDate)) / 1000 / 60 / 60/ 24 / 365;
}

var provideService = ({name, birthDate}, serve, refuse ) =>{
    calculateAge(birthDate) >= 18 ? 
        serve(name) : 
        refuse(name);
}