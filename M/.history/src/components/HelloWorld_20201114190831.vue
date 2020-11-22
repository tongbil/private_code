<template>
  <div>
    {{ msg }}
    <Footer> </Footer>
  </div>
</template>

<script>
import Footer from "./Footer";
export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "主页",
    };
  },
  components,
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
