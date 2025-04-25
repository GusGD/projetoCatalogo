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

      <template #default>
        <div v-if="products.length > 0" class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 mt-6">
          <div
            v-for="product in products"
            :key="product.id"
            class="bg-white border rounded-xl p-4 shadow-md flex flex-col items-start"
          >
            <h2 class="text-lg font-semibold text-[#263238]">{{ product.name }}</h2>
            <p class="text-sm text-gray-600 mt-1">{{ product.description }}</p>
            <span class="mt-2 font-bold text-[#1e88e5]">R$ {{ product.price.toFixed(2) }}</span>
          </div>
        </div>

        <p v-else class="text-gray-500 text-center mt-6">Nenhum produto encontrado.</p>
      </template>
    </Card>
  </div>
</template>

<script setup lang="ts">
import Card from '@/components/ui/card.vue';
import { ref, onMounted } from 'vue';
import { getProducts } from '@/api/api';

const products = ref<any[]>([]);

onMounted(async () => {
  try {
    const response = await getProducts();
    products.value = response.data.content;
  } catch (error) {
    console.error('Erro ao buscar produtos:', error);
  }
});
</script>
