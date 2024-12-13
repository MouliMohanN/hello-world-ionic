 import { registerPlugin } from '@capacitor/core';

type OutputProps = {
    isSecure: boolean,
    title: string,
    message: string
}
export interface SecurityPlugin {
  isAppSecure(): Promise<OutputProps>;
}


const Security = registerPlugin<SecurityPlugin>('Security');

 export default Security;