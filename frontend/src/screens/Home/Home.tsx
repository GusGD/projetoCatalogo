import { ArrowRightIcon } from "lucide-react";
import React from "react";
import { useNavigate } from "react-router-dom";
import { Button } from "../../components/ui/button";
import { Card, CardContent } from "../../components/ui/card";

export const Home = (): JSX.Element => {
  const navigate = useNavigate();

  return (
    <div className="w-full min-h-[956px] bg-[#f2f2f2] pt-10 px-10">
      <Card className="w-full max-w-[1360px] mx-auto rounded-[20px] shadow-[0px_4px_20px_#00000040] p-8">
        <CardContent className="p-0">
          <div className="flex flex-col lg:flex-row justify-between items-center gap-8 py-8">
            {/* Left Content - Text and CTA */}
            <div className="max-w-[516px]">
              <h1 className="font-['Open_Sans',Helvetica] font-bold text-[#263238] text-[55px] tracking-[-0.82px] leading-tight mb-6">
                Conheça o melhor
                <br />
                catálogo de produtos
              </h1>

              <p className="font-['Open_Sans',Helvetica] font-normal text-[#9e9d9d] text-2xl tracking-[-0.36px] mb-12">
                Ajudaremos você a encontrar os melhores produtos disponíveis no
                mercado.
              </p>

              <div className="flex">
                <Button
                  className="h-[70px] px-8 bg-[#407bff] rounded-l-[10px] rounded-r-none font-['Open_Sans',Helvetica] font-bold text-2xl"
                  onClick={() => navigate("/catalog")}
                >
                  INICIE AGORA A SUA BUSCA
                </Button>
                <div className="w-[70px] h-[70px] bg-[#26323880] rounded-r-[10px] flex items-center justify-center">
                  <ArrowRightIcon className="h-6 w-6 text-white" />
                </div>
              </div>
            </div>

            {/* Right Content - Illustration */}
            <div className="relative w-full max-w-[648px] h-[481px]">
              <img
                className="w-full h-[443px] object-contain"
                alt="Background complete"
                src="/background-complete.png"
              />
              <img
                className="absolute w-[503px] h-[29px] bottom-0 left-1/2 transform -translate-x-1/2"
                alt="Shadow"
                src="/shadow.png"
              />

              {/* Person illustration */}
              <div className="absolute w-[228px] h-[338px] top-[117px] left-[189px]">
                <div className="relative h-[338px]">
                  <img
                    className="absolute w-[99px] h-[126px] top-[211px] left-[71px]"
                    alt="Vector"
                    src="/vector.svg"
                  />
                  <img
                    className="absolute w-[99px] h-[126px] top-[211px] left-0.5"
                    alt="Vector"
                    src="/vector-36.svg"
                  />
                  <img
                    className="absolute w-[109px] h-[167px] top-[45px] left-0"
                    alt="Vector"
                    src="/vector-34.svg"
                  />
                  <img
                    className="absolute w-[88px] h-[15px] top-[198px] left-[66px]"
                    alt="Vector"
                    src="/vector-43.svg"
                  />
                  <img
                    className="absolute w-[170px] h-[292px] top-[45px] left-0"
                    alt="Group"
                    src="/group.png"
                  />
                  <img
                    className="absolute w-[49px] h-[65px] top-8 left-[45px]"
                    alt="Vector"
                    src="/vector-49.svg"
                  />
                  <img
                    className="absolute w-5 h-[17px] top-[30px] left-[75px]"
                    alt="Vector"
                    src="/vector-48.svg"
                  />
                  <img
                    className="absolute w-5 h-[17px] top-[30px] left-[75px]"
                    alt="Vector"
                    src="/vector-48.svg"
                  />
                  <img
                    className="absolute w-[63px] h-[55px] top-[94px] left-[126px]"
                    alt="Vector"
                    src="/vector-39.svg"
                  />
                  <img
                    className="absolute w-[26px] h-9 top-[78px] left-[118px]"
                    alt="Vector"
                    src="/vector-7.svg"
                  />
                  <img
                    className="absolute w-[26px] h-9 top-[78px] left-[118px]"
                    alt="Vector"
                    src="/vector-7.svg"
                  />
                  <img
                    className="absolute w-5 h-[29px] top-[85px] left-[120px]"
                    alt="Vector"
                    src="/vector-9.svg"
                  />
                  <img
                    className="absolute w-[73px] h-[85px] top-[75px] left-[65px]"
                    alt="Vector"
                    src="/vector-2.svg"
                  />
                  <img
                    className="absolute w-[73px] h-[85px] top-[75px] left-[65px]"
                    alt="Vector"
                    src="/vector-2.svg"
                  />
                  <img
                    className="absolute w-3 h-[17px] top-[131px] left-[185px]"
                    alt="Vector"
                    src="/vector-10.svg"
                  />
                  <img
                    className="absolute w-3 h-[15px] top-[130px] left-[196px]"
                    alt="Vector"
                    src="/vector-3.svg"
                  />
                  <img
                    className="absolute w-4 h-[31px] top-[293px] left-[191px]"
                    alt="Vector"
                    src="/vector-1.svg"
                  />
                  <img
                    className="absolute w-[18px] h-[31px] top-[293px] left-[139px]"
                    alt="Vector"
                    src="/vector-1.svg"
                  />
                  <img
                    className="absolute w-[42px] h-[15px] top-[323px] left-[135px]"
                    alt="Vector"
                    src="/vector-5.svg"
                  />
                  <img
                    className="absolute w-10 h-[15px] top-[323px] left-[188px]"
                    alt="Vector"
                    src="/vector-55.svg"
                  />
                  <img
                    className="absolute w-4 h-[23px] top-5 left-[113px]"
                    alt="Vector"
                    src="/vector-15.svg"
                  />
                  <img
                    className="absolute w-[15px] h-4 top-[293px] left-48"
                    alt="Vector"
                    src="/vector-21.svg"
                  />
                  <img
                    className="absolute w-4 h-4 top-[293px] left-[141px]"
                    alt="Vector"
                    src="/vector-20.svg"
                  />
                  <img
                    className="absolute w-1.5 h-[25px] top-[97px] left-[70px]"
                    alt="Vector"
                    src="/vector-26.svg"
                  />
                  <img
                    className="absolute w-[27px] h-9 top-12 left-[88px]"
                    alt="Vector"
                    src="/vector-47.svg"
                  />
                  <img
                    className="absolute w-[5px] h-[3px] top-[82px] left-[102px]"
                    alt="Vector"
                    src="/vector-28.svg"
                  />
                  <img
                    className="absolute w-[5px] h-0.5 top-[82px] left-[107px]"
                    alt="Vector"
                    src="/vector-54.svg"
                  />
                  <img
                    className="absolute w-5 h-5 top-[72px] left-[86px]"
                    alt="Vector"
                    src="/vector-31.svg"
                  />
                  <img
                    className="absolute w-2 h-[18px] top-[74px] left-[108px]"
                    alt="Vector"
                    src="/vector-52.svg"
                  />
                  <img
                    className="absolute w-[9px] h-3 top-[53px] left-24"
                    alt="Vector"
                    src="/vector-17.svg"
                  />
                  <img
                    className="absolute w-[38px] h-[52px] top-2.5 left-[88px]"
                    alt="Vector"
                    src="/vector-19.svg"
                  />
                  <img
                    className="absolute w-[53px] h-[41px] top-px left-[77px]"
                    alt="Vector"
                    src="/vector-14.svg"
                  />
                  <img
                    className="absolute w-[22px] h-3 top-0 left-[106px]"
                    alt="Vector"
                    src="/vector-23.svg"
                  />
                  <img
                    className="absolute w-[9px] h-[13px] top-[34px] left-[85px]"
                    alt="Vector"
                    src="/vector-18.svg"
                  />
                  <img
                    className="absolute w-[130px] h-[146px] top-[161px] left-[89px]"
                    alt="Vector"
                    src="/vector-12.svg"
                  />
                  <img
                    className="absolute w-[103px] h-[146px] top-[161px] left-[72px]"
                    alt="Vector"
                    src="/vector-6.svg"
                  />
                  <img
                    className="absolute w-[3px] h-1 top-8 left-[109px]"
                    alt="Vector"
                    src="/vector-11.svg"
                  />
                  <img
                    className="absolute w-[3px] h-1 top-[34px] left-[121px]"
                    alt="Vector"
                    src="/vector-11.svg"
                  />
                  <img
                    className="absolute w-[3px] h-px top-[34px] left-[122px]"
                    alt="Vector"
                    src="/vector-8.svg"
                  />
                  <img
                    className="absolute w-1 h-2 top-[37px] left-[116px]"
                    alt="Vector"
                    src="/vector-13.svg"
                  />
                  <img
                    className="absolute w-[7px] h-[5px] top-[43px] left-[105px]"
                    alt="Vector"
                    src="/vector-25.svg"
                  />
                  <img
                    className="absolute w-1.5 h-0.5 top-[27px] left-[105px]"
                    alt="Vector"
                    src="/vector-22.svg"
                  />
                  <img
                    className="absolute w-[5px] h-1 top-[27px] left-[123px]"
                    alt="Vector"
                    src="/vector-42.svg"
                  />
                  <img
                    className="absolute w-14 h-[59px] top-[94px] left-[49px]"
                    alt="Vector"
                    src="/vector-16.svg"
                  />
                  <img
                    className="absolute w-[7px] h-[3px] top-[322px] left-[154px]"
                    alt="Vector"
                    src="/vector-27.svg"
                  />
                  <img
                    className="absolute w-1 h-1.5 top-[319px] left-[154px]"
                    alt="Vector"
                    src="/vector-38.svg"
                  />
                  <img
                    className="absolute w-2 h-[3px] top-[322px] left-[206px]"
                    alt="Vector"
                    src="/vector-24.svg"
                  />
                  <img
                    className="absolute w-[5px] h-1.5 top-[319px] left-[206px]"
                    alt="Vector"
                    src="/vector-33.svg"
                  />
                  <img
                    className="absolute w-[18px] h-3 top-[124px] left-[97px]"
                    alt="Vector"
                    src="/vector-35.svg"
                  />
                  <img
                    className="absolute w-4 h-[15px] top-[124px] left-[108px]"
                    alt="Vector"
                    src="/vector-30.svg"
                  />
                  <img
                    className="absolute w-[3px] h-px top-8 left-[110px]"
                    alt="Vector"
                    src="/vector-8.svg"
                  />
                  <img
                    className="absolute w-[58px] h-1.5 top-[157px] left-[73px]"
                    alt="Vector"
                    src="/vector-29.svg"
                  />
                  <img
                    className="absolute w-[3px] h-[7px] top-[157px] left-[79px]"
                    alt="Vector"
                    src="/vector-37.svg"
                  />
                  <img
                    className="absolute w-[3px] h-[7px] top-[157px] left-[123px]"
                    alt="Vector"
                    src="/vector-51.svg"
                  />
                  <img
                    className="absolute w-[3px] h-[7px] top-[157px] left-[101px]"
                    alt="Vector"
                    src="/vector-45.svg"
                  />
                  <img
                    className="absolute w-[27px] h-[38px] top-[79px] left-[52px]"
                    alt="Vector"
                    src="/vector-41.svg"
                  />
                  <img
                    className="absolute w-[27px] h-[38px] top-[79px] left-[52px]"
                    alt="Vector"
                    src="/vector-41.svg"
                  />
                </div>
              </div>

              {/* Desk and accessories */}
              <img
                className="absolute w-[311px] h-[210px] top-[261px] left-[244px]"
                alt="Desk"
                src="/desk.png"
              />
              <img
                className="absolute w-[148px] h-[60px] top-[205px] left-[316px]"
                alt="Computer"
                src="/computer.png"
              />
              <img
                className="absolute w-[37px] h-[58px] top-[206px] left-[480px]"
                alt="Plant"
                src="/plant.png"
              />
              <img
                className="absolute w-[142px] h-[98px] top-[83px] left-[352px]"
                alt="Graphics"
                src="/graphics.png"
              />
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};