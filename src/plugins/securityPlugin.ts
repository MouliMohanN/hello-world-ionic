 import { registerPlugin } from '@capacitor/core';

type OutputProps = {
    isSecure: boolean,
    title: string,
    message: string
}

type ObfuscatedOutputProps = {
  // isSecure
  qzYjgxtf: boolean,
  // title
  ymwnf: string,
  // message
  tkxwdif: string
}

interface ObfuscatedSecurityPlugin {
  // isAppSecure
  tcJxwYjgxtf(): Promise<ObfuscatedOutputProps>;
}


const Security = registerPlugin<ObfuscatedSecurityPlugin>('Alizvlvz');

const SecurityPlugin = {
  isAppSecure: async (): Promise<OutputProps> => {
    const { qzYjgxtf: isSecure, ymwnf: title, tkxwdif: message } = await Security.tcJxwYjgxtf();
    return {
      isSecure,
      title,
      message
    }
   }
};
 
export default SecurityPlugin;