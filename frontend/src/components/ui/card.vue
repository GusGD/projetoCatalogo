<template>
  <div :class="['rounded-xl border bg-white text-black shadow-lg w-full', className]">
    <div v-if="$slots.header" class="flex flex-col space-y-1.5 p-6">
      <slot name="header" />
    </div>

    <div v-if="$slots.title" class="p-6 pt-0 font-semibold leading-none tracking-tight">
      <slot name="title" />
    </div>

    <div v-if="$slots.description" class="px-6 text-sm text-muted-foreground">
      <slot name="description" />
    </div>

    <div v-if="$slots.default" class="p-6 pt-0">
      <slot />
    </div>

    <div v-if="$slots.footer" class="flex items-center p-6 pt-0">
      <slot name="footer" />
    </div>
  </div>
</template>

<script setup lang="ts">
defineProps<{ className?: string }>();
</script>
