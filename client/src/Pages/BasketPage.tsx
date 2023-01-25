import { FC } from 'react';
import styled from 'styled-components';
import BasketList from 'Components/BasketPage/BasketList';
import { BGcontainer } from 'Components/Common/BGcontainer';
import BestProductSlider from 'Components/BestProductSlider';

const Cart = styled.div`
  margin-top: 120px;
`;
const BasketForm = styled.div`
  width: 1180px;
  padding: 70px 0;
  margin: -50px auto 0 auto;
`;
const BasketTitle = styled.h2`
  font-size: var(--xlarge);
  font-weight: bold;
  padding-bottom: 40px;
`;

const basketsPage: FC = () => {
  return (
    <BGcontainer>
      <Cart>
        <BestProductSlider></BestProductSlider>
        <BasketForm>
          <BasketTitle>장바구니</BasketTitle>
          <BasketList />
        </BasketForm>
      </Cart>
    </BGcontainer>
  );
};

export default basketsPage;
