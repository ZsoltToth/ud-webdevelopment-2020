
const validate = ({age}) =>{
    return age >= 18;
}

const submitOrder = (customer, success, failure) =>{
    if(!validate(customer)){
        failure();
        return;
    }
    success();
}

module.exports = {
    _validate : validate,
    submit : submitOrder
}
