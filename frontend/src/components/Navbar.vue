<template>
  <header class="w-full h-[70px] bg-[#407bff] flex items-center px-10">
    <router-link 
      to="/"
      class="font-['Open_Sans',Helvetica] font-bold text-white text-2xl tracking-[-0.36px]"
    >
      DS Catalog
    </router-link>

    <nav class="flex gap-x-14 mx-auto">
      <router-link
        v-for="item in navItems"
        :key="item.name"
        :to="item.path"
        class="font-['Open_Sans',Helvetica] text-lg text-center tracking-[-0.27px]"
        :class="route.path === item.path ? 'font-bold text-white' : 'font-semibold text-[#ffffff80]'"
      >
        {{ item.name }}
      </router-link>
    </nav>
  </header>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';

const route = useRoute();

const navItems = [
  { name: "HOME", path: "/" },
  { name: "CATÁLOGO", path: "/catalog" },
  { name: "ADMIN", path: "/admin" },
];
</script>