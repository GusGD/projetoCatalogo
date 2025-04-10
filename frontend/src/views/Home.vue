<template>
  <div class="w-full min-h-screen bg-[#f2f2f2] pt-10 px-4 md:px-10">
    <Card class="w-full max-w-[1360px] mx-auto p-8">
      <template #default>
        <div class="flex flex-col lg:flex-row justify-between items-center gap-8 py-8">
          <!-- Texto e CTA -->
          <div class="max-w-[516px]">
            <h1 class="font-['Open_Sans',Helvetica] font-bold text-[#263238] text-[36px] md:text-[55px] tracking-[-0.82px] leading-tight mb-6">
              Conheça o melhor<br />catálogo de produtos
            </h1>

            <p class="font-['Open_Sans',Helvetica] font-normal text-[#9e9d9d] text-xl md:text-2xl tracking-[-0.36px] mb-12">
              Ajudaremos você a encontrar os melhores produtos disponíveis no mercado.
            </p>

            <div class="flex">
              <button
                class="h-[70px] px-8 bg-[#407bff] rounded-l-[10px] rounded-r-none font-['Open_Sans',Helvetica] font-bold text-2xl text-white"
                @click="router.push('/catalog')"
              >
                INICIE AGORA A SUA BUSCA
              </button>
              <div class="w-[70px] h-[70px] bg-[#26323880] rounded-r-[10px] flex items-center justify-center">
                <ArrowRight class="h-6 w-6 text-white" />
              </div>
            </div>
          </div>

          <!-- Ilustração -->
          <div class="relative w-full max-w-[648px] h-[481px]">
            <img
              class="w-full h-[443px] object-contain"
              alt="Background complete"
              src="/background-complete.png"
            />
            <img
              class="absolute w-[503px] h-[29px] bottom-0 left-1/2 transform -translate-x-1/2"
              alt="Shadow"
              src="/shadow.png"
            />

            <!-- Ilustrações adicionais -->
            <div class="absolute w-[228px] h-[338px] top-[117px] left-[189px]">
              <img
                class="absolute w-[311px] h-[210px] top-[261px] left-[244px]"
                alt="Desk"
                src="/desk.png"
              />
              <img
                class="absolute w-[148px] h-[60px] top-[205px] left-[316px]"
                alt="Computer"
                src="/computer.png"
              />
              <img
                class="absolute w-[37px] h-[58px] top-[206px] left-[480px]"
                alt="Plant"
                src="/plant.png"
              />
              <img
                class="absolute w-[142px] h-[98px] top-[83px] left-[352px]"
                alt="Graphics"
                src="/graphics.png"
              />
            </div>
          </div>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup lang="ts">
import Card from '@/components/ui/card.vue';
import { ArrowRight } from 'lucide-vue-next';
import { useRouter } from 'vue-router';

const router = useRouter();
</script>
