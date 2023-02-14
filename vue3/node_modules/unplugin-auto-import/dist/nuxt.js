"use strict";Object.defineProperty(exports, "__esModule", {value: true});

var _chunkWM5DCFTOjs = require('./chunk-WM5DCFTO.js');
require('./chunk-4TIVKDW3.js');

// src/nuxt.ts
function nuxt_default(options) {
  options.exclude = options.exclude || [/[\\/]node_modules[\\/]/, /[\\/]\.git[\\/]/, /[\\/]\.nuxt[\\/]/];
  this.extendBuild((config) => {
    config.plugins = config.plugins || [];
    config.plugins.unshift(_chunkWM5DCFTOjs.src_default.webpack(options));
  });
  this.nuxt.hook("vite:extend", async (vite) => {
    vite.config.plugins = vite.config.plugins || [];
    vite.config.plugins.push(_chunkWM5DCFTOjs.src_default.vite(options));
  });
}


module.exports = nuxt_default;
exports.default = module.exports;