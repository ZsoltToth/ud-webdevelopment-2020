const path = require('path');

module.exports = {
    output: {
        path: path.resolve(__dirname,'dist','js'),
        filename: "bundle.js",
        library: {
            type: 'umd',
            name: 'App'
        }
    }
};
