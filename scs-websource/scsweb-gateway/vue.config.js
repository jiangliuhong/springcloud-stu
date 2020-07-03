module.exports = {
    publicPath: "./",
    outputDir: "dist",
    assetsDir: "static",
    indexPath: "index.html",
    devServer: {
        open: true,
        host: "127.0.0.1",
        port: 18000,
        https: false,
        hotOnly: false,
        proxy: {
            "/api":{
                target: process.env.VUE_APP_BASEURL,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                },
                changeOrigin: true
            }
        }
    }
};