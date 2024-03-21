//const { defineConfig } = require('@vue/cli-service')
//module.exports = defineConfig({
//  // lintOnSave: false,
//  transpileDependencies: true
//})

const { defineConfig } = require('@vue/cli-service')

module.exports = {
  lintOnSave: false, // eslint 해제
  outputDir: '../src/main/resources/static', // 빌드 타겟 디렉토리
  indexPath: 'index.html',
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        // '/api' 로 들어오면 포트 8081(스프링 서버)로 보낸다
        target: 'http://localhost:3081',
        changeOrigin: true // cross origin 허용
        /*
        pathRewrite: {
          '^/api': '/api/itemList'
        }
        */
      }
    }
  }
};
