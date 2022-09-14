<script setup lang="ts">
import store from '../../store'
</script>

<template>
    <button @click="store.commit('toggleTheme')">
        {{store.state.darkTheme ? "☀️" : "🌑"}}
    </button>
</template>

<style scoped>
</style>
