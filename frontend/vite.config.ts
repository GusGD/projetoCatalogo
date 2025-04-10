import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import tailwind from 'tailwindcss';

export default defineConfig({
  plugins: [vue()],
  base: './',
  css: {
    postcss: {
      plugins: [tailwind()],
    },
  },
});