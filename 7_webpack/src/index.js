
const greetings = ({name = 'World'}, callback) =>{
    callback(`Bye ${name}!`);
}

module.exports = {
    greetings : greetings
}
