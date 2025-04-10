<template>
  <div class="w-full min-h-screen bg-[#f2f2f2] pt-10 px-4">
    <div class="max-w-[1360px] mx-auto">
      <Card className="w-full">
        <template #title>
          <h1 class="font-bold text-[#263238] text-4xl sm:text-5xl leading-tight">
            Área administrativa
          </h1>
        </template>

        <template #description>
          <p class="text-[#9e9d9d] text-xl sm:text-2xl">
            Gerencie seus produtos
          </p>
        </template>
      </Card>
    </div>
  </div>
</template>

<script setup lang="ts">
import Card from '@/components/ui/card.vue'
</script>
