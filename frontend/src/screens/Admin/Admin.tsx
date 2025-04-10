import React from "react";
import { Card } from "../../components/ui/card";

export const Admin = (): JSX.Element => {
  return (
    <div className="w-full min-h-[956px] bg-[#f2f2f2] pt-10 px-10">
      <Card className="w-full max-w-[1360px] mx-auto rounded-[20px] shadow-[0px_4px_20px_#00000040] p-8">
        <h1 className="font-['Open_Sans',Helvetica] font-bold text-[#263238] text-[55px] tracking-[-0.82px] leading-tight mb-6">
          Área administrativa
        </h1>
        <p className="font-['Open_Sans',Helvetica] font-normal text-[#9e9d9d] text-2xl tracking-[-0.36px]">
          Gerencie seus produtos
        </p>
      </Card>
    </div>
  );
};