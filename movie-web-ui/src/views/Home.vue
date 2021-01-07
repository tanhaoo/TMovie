<template>
  <el-container>
    <el-header class="header" style="height: 100px; ">Header</el-header>
    <el-main>
      <div class="home">
        <img alt="Vue logo" src="../assets/logo.png">
        <HelloWorld msg="Welcome to Your Vue.js App"/>
      </div>
    </el-main>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import {getPageMovie} from 'api/index.js'

let pageNum = 1
let pageSize = 10
export default {
  name: 'Home',
  components: {
    HelloWorld
  }, methods: {
    showMovie() {
      getPageMovie({pageNum, pageSize}).then(
          res => {
            console.log(res)
          }
      )
    }
  },
  mounted() {
    this.showMovie()
  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
.header {
  height: 400px;
}
</style>

