<template>
  <div class="w-full min-h-screen bg-[#f2f2f2] pt-10 px-4 md:px-10">
    <Card class="w-full max-w-[1360px] mx-auto p-8">
      <template #header>
        <h1 class="font-['Open_Sans',Helvetica] font-bold text-[#263238] text-[36px] md:text-[55px] tracking-[-0.82px] leading-tight mb-4">
          Catálogo de produtos
        </h1>
        <p class="font-['Open_Sans',Helvetica] font-normal text-[#9e9d9d] text-xl md:text-2xl tracking-[-0.36px]">
          Encontre os melhores produtos do mercado
        </p>
      </template>
    </Card>
  </div>
</template>

<script setup lang="ts">
import Card from '@/components/ui/card.vue';
</script>
