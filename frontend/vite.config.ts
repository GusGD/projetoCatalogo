import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import tailwind from 'tailwindcss';
import path from 'node:path';


export default defineConfig({
  plugins: [vue()],
  base: './',
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'), 
    },
  },
  css: {
    postcss: {
      plugins: [tailwind()],
    },
  },
});
