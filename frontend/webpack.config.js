module.exports = {
    entry: [
        './src/index' // Your appʼs entry point
    ],
    output: {
        path: __dirname + '/public/',
        filename: "bundle.js"
    },
    module: {
        loaders: [{
            test: /\.js$/,
            exclude: /(node_modules|bower_components)/,
            loader: 'babel', // 'babel-loader' is also a valid name to reference
            query: {
                presets: ['es2015', 'react']
            }
        },
        {
            test: /\.less$/,
            loader: "style-loader!css-loader!less-loader"
        },
        {
            test: /\.css$/,
            loader: "style-loader!css-loader"
        },
        {
            test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)(\?.*)?$/,
            loader: 'url?limit=50000'
        }
        ]
    }
};