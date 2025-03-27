import { registerPlugin } from '@capacitor/core';
 
export const SecurityType = {
  NONE: 'STD_07',
  DEVELOPER_OPTIONS: 'STD_01'
}

type OutputProps = {
    type: string,
    title: string,
    message: string
}

type ObfuscatedOutputProps = {
  // type
  xbrf: string,
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
    const { xbrf: type, ymwnf: title, tkxwdif: message } = await Security.tcJxwYjgxtf();
    return {
      type,
      title,
      message
    }
   }
};
 
export default SecurityPlugin;