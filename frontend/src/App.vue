<template>
  <div class="bg-white flex flex-row justify-center w-full">
    <div class="bg-white overflow-hidden w-full max-w-[1440px]">
      <div class="relative min-h-screen">
        <Navbar />
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import Navbar from './components/Navbar.vue';
</script>