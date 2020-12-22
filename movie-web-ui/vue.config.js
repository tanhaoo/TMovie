const path = require('path')

function resolve(dir) {
    return path.join(__dirname, dir)
}

module.exports = {
    publicPath: "./",
    outputDir: "dist",
    configureWebpack: {
        resolve: {
            alias: {
                'api': resolve('src/api'),
                '@static': resolve('static')
            }
        }
    },
    devServer: {
        open: true,
        host: 'localhost',
        port: 8080,
        https: false,
        hotOnly: false,
        // http 代理配置
        proxy: {
            '/api': {
                target: 'http://127.0.0.1:4000',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            },

        },
    }
}
