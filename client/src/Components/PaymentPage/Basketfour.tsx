import { TYPE_CartData } from 'Types/common/product';
import React from 'react';
import { useNumberComma } from 'Utils/commonFunction';
interface Props {
  data: TYPE_CartData;
}
const BasketFour: React.FC<Props> = ({ data }) => {
  return (
    <div className="mt-5 relative  h-32 w-12/12">
      <div>
        <img
          className="absolute top-0 left-0 w-28 h-28"
          src={data.photo}
          alt="carousel"
        ></img>

        <div className=" pl-36 h-28 w-full table-cell align-middle">
          <div>
            <div>{data.productName}</div>
            <div> {data.productOptionName}</div>
          </div>
          <p className="absolute w-44 top-12 right-0 text-right">
            {data.quantity}개
            <strong className="w-36 inline-block">
              {useNumberComma(data.productPrice + data.productOptionPrice)}
              <span>원</span>
            </strong>
          </p>
        </div>
      </div>
    </div>
  );
};

export default BasketFour;
