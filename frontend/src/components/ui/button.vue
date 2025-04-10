<template>
  <div :class="['rounded-xl border bg-card text-card-foreground shadow', className]">
    <slot />
  </div>
</template>

<script lang="ts" setup>
defineProps<{ className?: string }>();
</script>
