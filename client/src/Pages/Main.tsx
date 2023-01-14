import ExampleBest from 'Components/BestProduct/BestCss';
import { Carousell } from 'Components/Carousel';
import NewCarousel from 'Components/NewProduct/NewCss';
import Example from 'Components/Review/ReviewCss';
import StartDive from 'Components/NewProduct/StartDive';
import Index from 'Components/Main/Nav/Index';
import { FC } from 'react';
import styles from './Styles/Main.module.css';

const Main: FC = (): JSX.Element => {
  return (
    <main className={styles.Main_Container}>
      <Index />
      <Carousell />
      <ExampleBest />
      <NewCarousel />
      <StartDive />
      <Example />
    </main>
  );
};

export default Main;
