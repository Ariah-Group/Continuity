U S E   [ m a s t e r ]  
 G O  
 C R E A T E   D A T A B A S E   [ C o n t i n u i t y ]  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   M O D I F Y   F I L E  
 (   N A M E   =   N ' C o n t i n u i t y ' ,   S I Z E   =   3 1 7 0 8 8 0 K B   ,   M A X S I Z E   =   U N L I M I T E D ,   F I L E G R O W T H   =   1 0 % )  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   M O D I F Y   F I L E  
 (   N A M E   =   N ' C o n t i n u i t y _ L o g '   ,   S I Z E   =   1 1 6 7 2 9 6 K B   ,   M A X S I Z E   =   U N L I M I T E D ,   F I L E G R O W T H   =   1 0 % )  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   C O M P A T I B I L I T Y _ L E V E L   =   1 0 0  
 G O  
 I F   ( 1   =   F U L L T E X T S E R V I C E P R O P E R T Y ( ' I s F u l l T e x t I n s t a l l e d ' ) )  
 b e g i n  
 E X E C   [ C o n t i n u i t y ] . [ d b o ] . [ s p _ f u l l t e x t _ d a t a b a s e ]   @ a c t i o n   =   ' d i s a b l e '  
 e n d  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A N S I _ N U L L _ D E F A U L T   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A N S I _ N U L L S   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A N S I _ P A D D I N G   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A N S I _ W A R N I N G S   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A R I T H A B O R T   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A U T O _ C L O S E   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A U T O _ C R E A T E _ S T A T I S T I C S   O N  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A U T O _ S H R I N K   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A U T O _ U P D A T E _ S T A T I S T I C S   O N  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   C U R S O R _ C L O S E _ O N _ C O M M I T   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   C U R S O R _ D E F A U L T     G L O B A L  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   C O N C A T _ N U L L _ Y I E L D S _ N U L L   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   N U M E R I C _ R O U N D A B O R T   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   R E C U R S I V E _ T R I G G E R S   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T     D I S A B L E _ B R O K E R  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A U T O _ U P D A T E _ S T A T I S T I C S _ A S Y N C   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   D A T E _ C O R R E L A T I O N _ O P T I M I Z A T I O N   O F F  
 G O  
 - - A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   T R U S T W O R T H Y   O F F  
 - - G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   A L L O W _ S N A P S H O T _ I S O L A T I O N   O F F  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   P A R A M E T E R I Z A T I O N   S I M P L E  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   R E A D _ C O M M I T T E D _ S N A P S H O T   O F F  
 G O  
 - - A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   P A R T N E R   T I M E O U T   1 0  
 - - G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T     R E A D _ W R I T E  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   R E C O V E R Y   F U L L  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T     M U L T I _ U S E R  
 G O  
 A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   P A G E _ V E R I F Y   T O R N _ P A G E _ D E T E C T I O N  
 G O  
 - - A L T E R   D A T A B A S E   [ C o n t i n u i t y ]   S E T   D B _ C H A I N I N G   O F F  
 - - G O  
 U S E   [ C o n t i n u i t y ]  
 G O  
 / * * * * * *   O b j e c t :     U s e r   [ r e s t a r t _ a p p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 2 9   * * * * * * /  
 - - C R E A T E   U S E R   [ r e s t a r t _ a p p ]   F O R   L O G I N   [ r e s t a r t _ a p p ]   W I T H   D E F A U L T _ S C H E M A = [ r e s t a r t _ a p p ]  
 - - G O  
 / * * * * * *   O b j e c t :     S c h e m a   [ r e s t a r t _ a p p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 2 9   * * * * * * /  
 - - C R E A T E   S C H E M A   [ r e s t a r t _ a p p ]   A U T H O R I Z A T I O N   [ r e s t a r t _ a p p ]  
 - - G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ I n s t r u c t i o n a l D e p a r t m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 0   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ I n s t r u c t i o n a l D e p a r t m e n t ] (  
 	 [ I n s t r u c t i o n a l D e p a r t m e n t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e p a r t m e n t N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ I n s t r u c t i o n a l D e p a r t m e n t ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ I n s t r u c t i o n a l D e p a r t m e n t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   f i e l d   f o r   t h e   t a b l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' I n s t r u c t i o n a l D e p a r t m e n t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t r u c t i o n a l D e p a r t m e n t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' I n s t r u c t i o n a l D e p a r t m e n t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' I n s t r u c t i o n a l D e p a r t m e n t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t N a m e '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e n e r a t e a n s i n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *    
 * * 	 G e n e r a t e   a n   a n s i   n a m e   t h a t   i s   u n i q u e   i n   t h e   d t p r o p e r t i e s . v a l u e   c o l u m n    
 * /    
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e n e r a t e a n s i n a m e ] ( @ n a m e   v a r c h a r ( 2 5 5 )   o u t p u t )    
 a s    
 	 d e c l a r e   @ p r o l o g u e   v a r c h a r ( 2 0 )    
 	 d e c l a r e   @ i n d e x s t r i n g   v a r c h a r ( 2 0 )    
 	 d e c l a r e   @ i n d e x   i n t e g e r    
    
 	 s e t   @ p r o l o g u e   =   ' M S D T - A - '    
 	 s e t   @ i n d e x   =   1    
    
 	 w h i l e   1   =   1    
 	 b e g i n    
 	 	 s e t   @ i n d e x s t r i n g   =   c a s t ( @ i n d e x   a s   v a r c h a r ( 2 0 ) )    
 	 	 s e t   @ n a m e   =   @ p r o l o g u e   +   @ i n d e x s t r i n g    
 	 	 i f   n o t   e x i s t s   ( s e l e c t   v a l u e   f r o m   d t p r o p e r t i e s   w h e r e   v a l u e   =   @ n a m e )    
 	 	 	 b r e a k    
 	 	    
 	 	 s e t   @ i n d e x   =   @ i n d e x   +   1    
    
 	 	 i f   ( @ i n d e x   =   1 0 0 0 0 )    
 	 	 	 g o t o   T o o M a n y    
 	 e n d    
    
 L e a v e :    
    
 	 r e t u r n    
    
 T o o M a n y :    
    
 	 s e t   @ n a m e   =   ' D I A G R A M '    
 	 g o t o   L e a v e  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ a d d u s e r o b j e c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 A d d   a n   o b j e c t   t o   t h e   d t p r o p e r t i e s   t a b l e  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ a d d u s e r o b j e c t ]  
 a s  
 	 s e t   n o c o u n t   o n  
 	 / *  
 	 * *   C r e a t e   t h e   u s e r   o b j e c t   i f   i t   d o e s   n o t   e x i s t   a l r e a d y  
 	 * /  
 	 b e g i n   t r a n s a c t i o n  
 	 	 i n s e r t   d b o . d t p r o p e r t i e s   ( p r o p e r t y )   V A L U E S   ( ' D t g S c h e m a O B J E C T ' )  
 	 	 u p d a t e   d b o . d t p r o p e r t i e s   s e t   o b j e c t i d = @ @ i d e n t i t y    
 	 	 	 w h e r e   i d = @ @ i d e n t i t y   a n d   p r o p e r t y = ' D t g S c h e m a O B J E C T '  
 	 c o m m i t  
 	 r e t u r n   @ @ i d e n t i t y  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ B u i l d i n g S o u r c e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ] (  
 	 [ B u i l d i n g I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ C A A N ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ B u i l d i n g N a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ B u i l d i n g C o m m o n N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ B u i l d i n g A d d r e s s ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ O w n e r s h i p ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ B u i l d i n g S o u r c e ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ B u i l d i n g I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   f i e l d   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C A A N   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C A A N '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   C o m m o n   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g C o m m o n N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   A d d r e s s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g A d d r e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O w n e r s h i p ( ' ' 1 ' '   -   o w n e d , ' ' 0 ' '   -   r e n t e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g S o u r c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O w n e r s h i p '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ s e t p r o p e r t y b y i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 I f   t h e   p r o p e r t y   a l r e a d y   e x i s t s ,   r e s e t   t h e   v a l u e ;   o t h e r w i s e   a d d   p r o p e r t y  
 * * 	 	 i d   - -   t h e   i d   i n   s y s o b j e c t s   o f   t h e   o b j e c t  
 * * 	 	 p r o p e r t y   - -   t h e   n a m e   o f   t h e   p r o p e r t y  
 * * 	 	 v a l u e   - -   t h e   t e x t   v a l u e   o f   t h e   p r o p e r t y  
 * * 	 	 l v a l u e   - -   t h e   b i n a r y   v a l u e   o f   t h e   p r o p e r t y   ( i m a g e )  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ s e t p r o p e r t y b y i d ]  
 	 @ i d   i n t ,  
 	 @ p r o p e r t y   v a r c h a r ( 6 4 ) ,  
 	 @ v a l u e   v a r c h a r ( 2 5 5 ) ,  
 	 @ l v a l u e   i m a g e  
 a s  
 	 s e t   n o c o u n t   o n  
 	 d e c l a r e   @ u v a l u e   n v a r c h a r ( 2 5 5 )    
 	 s e t   @ u v a l u e   =   c o n v e r t ( n v a r c h a r ( 2 5 5 ) ,   @ v a l u e )    
 	 i f   e x i s t s   ( s e l e c t   *   f r o m   d b o . d t p r o p e r t i e s    
 	 	 	 w h e r e   o b j e c t i d = @ i d   a n d   p r o p e r t y = @ p r o p e r t y )  
 	 b e g i n  
 	 	 - -  
 	 	 - -   b u m p   t h e   v e r s i o n   c o u n t   f o r   t h i s   r o w   a s   w e   u p d a t e   i t  
 	 	 - -  
 	 	 u p d a t e   d b o . d t p r o p e r t i e s   s e t   v a l u e = @ v a l u e ,   u v a l u e = @ u v a l u e ,   l v a l u e = @ l v a l u e ,   v e r s i o n = v e r s i o n + 1  
 	 	 	 w h e r e   o b j e c t i d = @ i d   a n d   p r o p e r t y = @ p r o p e r t y  
 	 e n d  
 	 e l s e  
 	 b e g i n  
 	 	 - -  
 	 	 - -   v e r s i o n   c o u n t   i s   a u t o - s e t   t o   0   o n   i n i t i a l   i n s e r t  
 	 	 - -  
 	 	 i n s e r t   d b o . d t p r o p e r t i e s   ( p r o p e r t y ,   o b j e c t i d ,   v a l u e ,   u v a l u e ,   l v a l u e )  
 	 	 	 v a l u e s   ( @ p r o p e r t y ,   @ i d ,   @ v a l u e ,   @ u v a l u e ,   @ l v a l u e )  
 	 e n d  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t o b j w i t h p r o p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 R e t r i e v e   t h e   o w n e r   o b j e c t ( s )   o f   a   g i v e n   p r o p e r t y  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t o b j w i t h p r o p ]  
 	 @ p r o p e r t y   v a r c h a r ( 3 0 ) ,  
 	 @ v a l u e   v a r c h a r ( 2 5 5 )  
 a s  
 	 s e t   n o c o u n t   o n  
  
 	 i f   ( @ p r o p e r t y   i s   n u l l )   o r   ( @ p r o p e r t y   =   ' ' )  
 	 b e g i n  
 	 	 r a i s e r r o r ( ' M u s t   s p e c i f y   a   p r o p e r t y   n a m e . ' , - 1 , - 1 )  
 	 	 r e t u r n   ( 1 )  
 	 e n d  
  
 	 i f   ( @ v a l u e   i s   n u l l )  
 	 	 s e l e c t   o b j e c t i d   i d   f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e   p r o p e r t y = @ p r o p e r t y  
  
 	 e l s e  
 	 	 s e l e c t   o b j e c t i d   i d   f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e   p r o p e r t y = @ p r o p e r t y   a n d   v a l u e = @ v a l u e  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n s ] (  
 	 [ p i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ p l a n _ n a m e ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ s t a t u s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ a c a d _ s t a f f ]   [ i n t ]   N O T   N U L L ,  
 	 [ f u l l t i m e _ s t a f f ]   [ i n t ]   N O T   N U L L ,  
 	 [ p a r t t i m e _ s t a f f ]   [ i n t ]   N O T   N U L L ,  
 	 [ s t u d e n t _ s t a f f ]   [ i n t ]   N O T   N U L L ,  
 	 [ o t h e r _ s t a f f ]   [ i n t ]   N O T   N U L L ,  
 	 [ r e s _ f e l l o w s ]   [ i n t ]   N O T   N U L L ,  
 	 [ v o l u n t e e r s ]   [ i n t ]   N O T   N U L L ,  
 	 [ g u e s t s ]   [ i n t ]   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ e m p l o y _ f a c u l t y ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ k e y _ w o r k s t a t i o n _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ w o r k s t a t i o n _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ l a p t o p _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ l a p t o p _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ t e l e p h o n e _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ t e l e p h o n e _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ p r i n t e r _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ p r i n t e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ f a x _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ f a x _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ c o p i e r _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ c o p i e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ s c a n n e r _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ s c a n n e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ s e r v e r _ m i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ k e y _ s e r v e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ o t h e r _ e q u i p m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ f a c i l i t i e s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ o t h e r _ r e s o u r c e s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ s u p p l y _ c r i s i s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ w h o _ h o l d ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ w h o _ u p d a t e ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ w h o _ c h e c k _ m s g ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ w h o _ p o s t _ m s g ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ s h a r e d _ p a s s w o r d ]   [ v a r c h a r ] ( 3 2 0 )   N O T   N U L L ,  
 	 [ k e y _ b a s i c _ c o m m e n t ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ k e y _ t r a n s p o r t a t i o n ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ i t _ w s _ f i l e ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ f i l e _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ u c b ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ u c b _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ l o c a l _ a u t o ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ l o c a l _ a u t o _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ l o c a l _ m a n u ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ l o c a l _ m a n u _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ o t h e r ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ o t h e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ n o _ b a c k u p ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ n o _ b a c k u p _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ n o t _ k n o w ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ i t _ w s _ n o t _ k n o w _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ d e p t _ f l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ d e p t _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ c a m p u s _ f l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ c a m p u s _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ v e n d o r _ f l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ v e n d o r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ o t h e r _ f l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ i t _ w s _ s u p p o r t _ o t h e r _ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ w h e r e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ w h e n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ r e q u i r e m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ s t a f f ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ o t h e r ]   [ t e x t ]   N O T   N U L L ,  
 	 [ c r e a t e _ d a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ l a s t _ m o d i f i e d ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ a p p r o v a l _ f l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ a p p r o v e d _ b y ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ a p p r o v e r _ t y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ a p p r o v e d _ d a t e ]   [ d a t e t i m e ]   N U L L ,  
 	 [ i t _ h o w t o _ w o r k _ h o m e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ k e y _ s u p p l i e s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ i t _ h o w t o _ c a n n o t _ w o r k _ a r o u n d ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o s t _ c e n t e r ]   [ t e x t ]   N O T   N U L L ,  
 	 [ e v a c u a t i o n _ p l a n ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ A c r o n y m I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ M a j o r D i v i s i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ H e a d O f U n i t N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ H e a d O f U n i t T i t l e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ n o t _ a p p l i c a b l e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ n a _ e x p l a i n ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ o l d _ p i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ p k _ p l a n ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ p i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ p l a n s ]   O N   [ d b o ] . [ p l a n s ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e s _ f e l l o w s   n u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' r e s _ f e l l o w s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' V o l u n t e e r s   n u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' v o l u n t e e r s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' G u e s t s   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' g u e s t s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y ( ' ' Y ' ' ,   ' ' N ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ w h o _ h o l d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ w h o _ h o l d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ w h o _ u p d a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ w h o _ u p d a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ w h o _ c h e c k _ m s g '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ w h o _ c h e c k _ m s g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ w h o _ p o s t _ m s g '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ w h o _ p o s t _ m s g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ s h a r e d _ p a s s w o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ s h a r e d _ p a s s w o r d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' k e y _ b a s i c _ c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k e y _ b a s i c _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r e a t e   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c r e a t e _ d a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A p p r o v a l   F l a g ( ' ' 1 ' '   -   a p p r o v e d ,   ' ' 0 ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a p p r o v a l _ f l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L a s t   P l a n   A p p r o v e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a p p r o v e d _ b y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' a p p r o v e r   T y p e ( ' ' 1 ' '   -   H e a d   o f   U n i t ,   ' ' 2 ' '   -   D e s i g n e e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a p p r o v e r _ t y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o s t   C e n t e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o s t _ c e n t e r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' E v a c u a t i o n   P l a n ( ' ' 1 ' '   -   Y e s ,   ' ' 2 ' '   -   N o ,   ' ' 3 ' '   -   S o m e ,   n o t   a l l ,   ' ' 4 ' '   -     D o n ' ' t   k n o w   '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' e v a c u a t i o n _ p l a n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A c r o n y m   I D ( u s e d   a s   a   p a r t   o f   p l a n   n a m e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A c r o n y m I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M a j o r   D i v i s i o n   I D ( l i n k e d   t o   M a j o r D i v i s i o n   t a b l e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' M a j o r D i v i s i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H e a d   o f   U n i t   N a m e   w h i c h   P l a n   i s   f o r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' H e a d O f U n i t N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H e a d   o f   U n i t   T i t l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' H e a d O f U n i t T i t l e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N o t   a p p l i c a b l e ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' n o t _ a p p l i c a b l e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' n o t   a p p l i c a b l e   e x p l a i n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' n a _ e x p l a i n '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 R e t r i e v e   p r o p e r t i e s   b y   i d ' s  
 * *  
 * * 	 d t _ g e t p r o p e r t i e s   o b j i d ,   n u l l   o r   ' '   - -   r e t r i e v e   a l l   p r o p e r t i e s   o f   t h e   o b j e c t   i t s e l f  
 * * 	 d t _ g e t p r o p e r t i e s   o b j i d ,   p r o p e r t y   - -   r e t r i e v e   t h e   p r o p e r t y   s p e c i f i e d  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d ]  
 	 @ i d   i n t ,  
 	 @ p r o p e r t y   v a r c h a r ( 6 4 )  
 a s  
 	 s e t   n o c o u n t   o n  
  
 	 i f   ( @ p r o p e r t y   i s   n u l l )   o r   ( @ p r o p e r t y   =   ' ' )  
 	 	 s e l e c t   p r o p e r t y ,   v e r s i o n ,   v a l u e ,   l v a l u e  
 	 	 	 f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e     @ i d = o b j e c t i d  
 	 e l s e  
 	 	 s e l e c t   p r o p e r t y ,   v e r s i o n ,   v a l u e ,   l v a l u e  
 	 	 	 f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e     @ i d = o b j e c t i d   a n d   @ p r o p e r t y = p r o p e r t y  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ v e r s t a m p 0 0 6 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 T h i s   p r o c e d u r e   r e t u r n s   t h e   v e r s i o n   n u m b e r   o f   t h e   s t o r e d  
 * *         p r o c e d u r e s   u s e d   b y   l e g a c y   v e r s i o n s   o f   t h e   M i c r o s o f t  
 * * 	 V i s u a l   D a t a b a s e   T o o l s .     V e r s i o n   i s   7 . 0 . 0 0 .  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ v e r s t a m p 0 0 6 ]  
 a s  
 	 s e l e c t   7 0 0 0  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ v e r s t a m p 0 0 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 T h i s   p r o c e d u r e   r e t u r n s   t h e   v e r s i o n   n u m b e r   o f   t h e   s t o r e d  
 * *         p r o c e d u r e s   u s e d   b y   t h e   t h e   M i c r o s o f t   V i s u a l   D a t a b a s e   T o o l s .  
 * * 	 V e r s i o n   i s   7 . 0 . 0 5 .  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ v e r s t a m p 0 0 7 ]  
 a s  
 	 s e l e c t   7 0 0 5  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ v c s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ v c s ]  
         @ i d               i n t ,  
         @ p r o p e r t y   v a r c h a r ( 6 4 ) ,  
         @ v a l u e         v a r c h a r ( 2 5 5 )   =   N U L L   O U T  
  
 a s  
  
         s e t   n o c o u n t   o n  
  
         s e l e c t   @ v a l u e   =   (  
                 s e l e c t   v a l u e  
                                 f r o m   d b o . d t p r o p e r t i e s  
                                 w h e r e   @ i d = o b j e c t i d   a n d   @ p r o p e r t y = p r o p e r t y  
                                 )  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ d i s p l a y o a e r r o r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 C R E A T E   P R O C E D U R E   [ d b o ] . [ d t _ d i s p l a y o a e r r o r ]  
         @ i O b j e c t   i n t ,  
         @ i r e s u l t   i n t  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ v c h O u t p u t             v a r c h a r ( 2 5 5 )  
 d e c l a r e   @ h r                           i n t  
 d e c l a r e   @ v c h S o u r c e             v a r c h a r ( 2 5 5 )  
 d e c l a r e   @ v c h D e s c r i p t i o n   v a r c h a r ( 2 5 5 )  
  
         e x e c   @ h r   =   m a s t e r . d b o . s p _ O A G e t E r r o r I n f o   @ i O b j e c t ,   @ v c h S o u r c e   O U T ,   @ v c h D e s c r i p t i o n   O U T  
  
         s e l e c t   @ v c h O u t p u t   =   @ v c h S o u r c e   +   ' :   '   +   @ v c h D e s c r i p t i o n  
         r a i s e r r o r   ( @ v c h O u t p u t , 1 6 , - 1 )  
  
         r e t u r n  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ a d d u s e r o b j e c t _ v c s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ a d d u s e r o b j e c t _ v c s ]  
         @ v c h P r o p e r t y   v a r c h a r ( 6 4 )  
  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ i R e t u r n   i n t  
         / *  
         * *   C r e a t e   t h e   u s e r   o b j e c t   i f   i t   d o e s   n o t   e x i s t   a l r e a d y  
         * /  
         b e g i n   t r a n s a c t i o n  
                 s e l e c t   @ i R e t u r n   =   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   @ v c h P r o p e r t y  
                 i f   @ i R e t u r n   I S   N U L L  
                 b e g i n  
                         i n s e r t   d b o . d t p r o p e r t i e s   ( p r o p e r t y )   V A L U E S   ( @ v c h P r o p e r t y )  
                         u p d a t e   d b o . d t p r o p e r t i e s   s e t   o b j e c t i d = @ @ i d e n t i t y  
                                         w h e r e   i d = @ @ i d e n t i t y   a n d   p r o p e r t y = @ v c h P r o p e r t y  
                         s e l e c t   @ i R e t u r n   =   @ @ i d e n t i t y  
                 e n d  
         c o m m i t  
         r e t u r n   @ i R e t u r n  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m L o g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m L o g ] (  
 	 [ S y s t e m L o g I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ O b j e c t T y p e ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ E v e n t T y p e ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ O b j e c t I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ H o s t I P ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ M o d u l e ]   [ v a r c h a r ] ( 2 0 0 )   N O T   N U L L ,  
 	 [ E v e n t D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ C o m m e n t ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m L o g ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ S y s t e m L o g I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S y s t e m   L o g   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S y s t e m L o g I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O b j e c t   T y p e ( ' ' x x ' '   -   s y s t e m ,   ' ' p l ' '   -   p l a n ,   ' ' c r ' '   -   c r i t i c a l   f u n c t i o n ,   ' ' a c ' '   -   a c t i o n   i t e m ,   ' ' u s ' '   -   u s e r   a c c o u n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O b j e c t T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' E v e n t T y p e ( ' ' i n ' '   -   l o g i n ,   ' ' c r ' '   -   c r e a t e d ,   ' ' m d ' '   -   m o d i f i e d ,   ' ' d l ' '   -   d e l e t e d ,   ' ' a c ' '   -   a c c e s s e d , ' ' r w ' '   -   r e v i e w   i n f o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E v e n t T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O b j e c t I D   ( 0   f o r   s y s t e m   l o g i n / l o g o u t ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O b j e c t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I D   r e s p o n s i b l e   f o r   E v e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H o s t   I P   o f   r e s p o n s i b l e   u s e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' H o s t I P '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U C   R e a d y   m o d u l e   r e s p o n s i b l e   f o r   e v e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' M o d u l e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' E v e n t   D a t e T i m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E v e n t D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t o b j w i t h p r o p _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 R e t r i e v e   t h e   o w n e r   o b j e c t ( s )   o f   a   g i v e n   p r o p e r t y  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t o b j w i t h p r o p _ u ]  
 	 @ p r o p e r t y   v a r c h a r ( 3 0 ) ,  
 	 @ u v a l u e   n v a r c h a r ( 2 5 5 )  
 a s  
 	 s e t   n o c o u n t   o n  
  
 	 i f   ( @ p r o p e r t y   i s   n u l l )   o r   ( @ p r o p e r t y   =   ' ' )  
 	 b e g i n  
 	 	 r a i s e r r o r ( ' M u s t   s p e c i f y   a   p r o p e r t y   n a m e . ' , - 1 , - 1 )  
 	 	 r e t u r n   ( 1 )  
 	 e n d  
  
 	 i f   ( @ u v a l u e   i s   n u l l )  
 	 	 s e l e c t   o b j e c t i d   i d   f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e   p r o p e r t y = @ p r o p e r t y  
  
 	 e l s e  
 	 	 s e l e c t   o b j e c t i d   i d   f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e   p r o p e r t y = @ p r o p e r t y   a n d   u v a l u e = @ u v a l u e  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 R e t r i e v e   p r o p e r t i e s   b y   i d ' s  
 * *  
 * * 	 d t _ g e t p r o p e r t i e s   o b j i d ,   n u l l   o r   ' '   - -   r e t r i e v e   a l l   p r o p e r t i e s   o f   t h e   o b j e c t   i t s e l f  
 * * 	 d t _ g e t p r o p e r t i e s   o b j i d ,   p r o p e r t y   - -   r e t r i e v e   t h e   p r o p e r t y   s p e c i f i e d  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ u ]  
 	 @ i d   i n t ,  
 	 @ p r o p e r t y   v a r c h a r ( 6 4 )  
 a s  
 	 s e t   n o c o u n t   o n  
  
 	 i f   ( @ p r o p e r t y   i s   n u l l )   o r   ( @ p r o p e r t y   =   ' ' )  
 	 	 s e l e c t   p r o p e r t y ,   v e r s i o n ,   u v a l u e ,   l v a l u e  
 	 	 	 f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e     @ i d = o b j e c t i d  
 	 e l s e  
 	 	 s e l e c t   p r o p e r t y ,   v e r s i o n ,   u v a l u e ,   l v a l u e  
 	 	 	 f r o m   d b o . d t p r o p e r t i e s  
 	 	 	 w h e r e     @ i d = o b j e c t i d   a n d   @ p r o p e r t y = p r o p e r t y  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ d r o p u s e r o b j e c t b y i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 D r o p   a n   o b j e c t   f r o m   t h e   d b o . d t p r o p e r t i e s   t a b l e  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ d r o p u s e r o b j e c t b y i d ]  
 	 @ i d   i n t  
 a s  
 	 s e t   n o c o u n t   o n  
 	 d e l e t e   f r o m   d b o . d t p r o p e r t i e s   w h e r e   o b j e c t i d = @ i d  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ d r o p p r o p e r t i e s b y i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 D r o p   o n e   o r   a l l   t h e   a s s o c i a t e d   p r o p e r t i e s   o f   a n   o b j e c t   o r   a n   a t t r i b u t e    
 * *  
 * * 	 d t _ d r o p p r o p e r t i e s   o b j i d ,   n u l l   o r   ' '   - -   d r o p   a l l   p r o p e r t i e s   o f   t h e   o b j e c t   i t s e l f  
 * * 	 d t _ d r o p p r o p e r t i e s   o b j i d ,   p r o p e r t y   - -   d r o p   t h e   p r o p e r t y  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ d r o p p r o p e r t i e s b y i d ]  
 	 @ i d   i n t ,  
 	 @ p r o p e r t y   v a r c h a r ( 6 4 )  
 a s  
 	 s e t   n o c o u n t   o n  
  
 	 i f   ( @ p r o p e r t y   i s   n u l l )   o r   ( @ p r o p e r t y   =   ' ' )  
 	 	 d e l e t e   f r o m   d b o . d t p r o p e r t i e s   w h e r e   o b j e c t i d = @ i d  
 	 e l s e  
 	 	 d e l e t e   f r o m   d b o . d t p r o p e r t i e s    
 	 	 	 w h e r e   o b j e c t i d = @ i d   a n d   p r o p e r t y = @ p r o p e r t y  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ D e s c r i p t i o n L o o k u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ D e s c r i p t i o n L o o k u p ] (  
 	 [ L o o k u p I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ L o o k u p N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ L o o k u p V a l u e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ L o o k u p D e s c r i p t i o n ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ D e s c r i p t i o n L o o k u p ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ L o o k u p I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ D e s c r i p t i o n L o o k u p ]   O N   [ d b o ] . [ D e s c r i p t i o n L o o k u p ]    
 (  
 	 [ L o o k u p N a m e ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e s c r i p t i o n L o o k u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o o k u p I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o o k u p   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e s c r i p t i o n L o o k u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o o k u p N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o o k u p   V a l u e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e s c r i p t i o n L o o k u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o o k u p V a l u e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o o k u p   D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e s c r i p t i o n L o o k u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o o k u p D e s c r i p t i o n '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ v c s e n a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ v c s e n a b l e d ]  
  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ i O b j e c t I d   i n t  
 s e l e c t   @ i O b j e c t I d   =   0  
  
 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
         d e c l a r e   @ i R e t u r n   i n t  
         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
         i f   @ i R e t u r n   < >   0   r a i s e r r o r ( ' ' ,   1 6 ,   - 1 )   / *   C a n ' t   L o a d   H e l p e r   D L L C   * /  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n G r o u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n G r o u p ] (  
 	 [ I n s t G r o u p I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m D o m a i n G r o u p ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ I n s t G r o u p I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n G r o u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t G r o u p I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   G r o u p   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n G r o u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ U s e r S e c u r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ] (  
 	 [ U s e r I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ A u t h I D ]   [ v a r c h a r ] ( 2 5 6 )   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ S e c u r i t y T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ F i r s t N a m e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ L a s t N a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ W o r k P h o n e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ H o m e P h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ C e l l P h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ E M a i l R e g u l a r ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ E M a i l B a c k u p ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ W o r k F A X ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ T i t l e ]   [ v a r c h a r ] ( 2 0 0 )   N O T   N U L L ,  
 	 [ D e p a r t m e n t N a m e ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ D e p a r t m e n t O r g ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ D e p a r t m e n t O r g H i e r a r c h y ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ W o r k A d d r e s s ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ H o m e A d d r e s s ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ A c c e s s S t a t u s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ L o c k S t a t u s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ C r e a t e d D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ A f f i l i a t i o n s ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ P a s s w o r d ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ S e c u r i t y A t t r i b u t e ]   [ i n t ]   N O T   N U L L ,  
 	 [ D i r e c t o r y I D ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L  
 )   O N   [ P R I M A R Y ]  
 S E T   A N S I _ P A D D I N G   O F F  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D   [ M o d A p p r o v e d F l a g ]   [ c h a r ] ( 1 )   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ P K _ U s e r S e c u r i t y ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ U s e r I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ U s e r S e c u r i t y _ 1 ]   O N   [ d b o ] . [ U s e r S e c u r i t y ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ U s e r S e c u r i t y ]   O N   [ d b o ] . [ U s e r S e c u r i t y ]    
 (  
 	 [ A u t h I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ U s e r S e c u r i t y _ 2 ]   O N   [ d b o ] . [ U s e r S e c u r i t y ]    
 (  
 	 [ F i r s t N a m e ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ U s e r S e c u r i t y _ 3 ]   O N   [ d b o ] . [ U s e r S e c u r i t y ]    
 (  
 	 [ L a s t N a m e ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I D   f o r   a u t h e n t i c a t i o n   m e t h o d   u s e d ,   u s e r   n a m e   f o r   a p p l i c a t i o n   p r o v i d e d   s e c u r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A u t h I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S e c u r i t y   T y p e ( ' ' 0 ' '   -   S y s t e m   A d m i n ,   ' ' 1 ' '   -   L o c a l   a d m i n ,   ' ' 2 ' '   -   U n i v e r s a l   v i e w e r ,   ' ' 9 ' '   -   l o c a l   u s e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S e c u r i t y T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' F i r s t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F i r s t N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L a s t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L a s t N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D a y   P h o n e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' W o r k P h o n e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H o m e   P h o n e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' H o m e P h o n e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C e l l   P h o n e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C e l l P h o n e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e g u l a r   E M a i l '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E M a i l R e g u l a r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B a c k u p   E M a i l '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E M a i l B a c k u p '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' W o r k   F A X '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' W o r k F A X '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' T i t l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T i t l e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i m a r y   D e p a r t m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t   O R G '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t O r g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t   O r g   O r g H i e r a r c h y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t O r g H i e r a r c h y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' W o r k   A d d r e s s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' W o r k A d d r e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H o m e   A d d r e s s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' H o m e A d d r e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A c c e s s   S t a t u s ( ' ' 1 ' '   -   e n a b l e d / O n ,   ' ' 0 ' '   -   d i s a b l e d / O f f ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A c c e s s S t a t u s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o c k   S t a t u s ( ' ' 0 ' '   -   u n l o c k e d ,   ' ' 1 ' '   -   l o c k e d )   p r e v e n t s   a u t o m a t i c   u p d a t e   i f   s e t ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o c k S t a t u s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A c c o u n t   C r e a t e d   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C r e a t e d D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   A f f i l i a t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A f f i l i a t i o n s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   p a s s w o r d   f o r   a p p l i c a t i o n   b a s e d   s e c u r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U s e r S e c u r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P a s s w o r d '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m U I T e x t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m U I T e x t ] (  
 	 [ U I T e x t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ U I T e x t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m U I T e x t ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ U I T e x t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I T e x t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U I   T e x t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I T e x t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ l o o k u p _ i t e m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ l o o k u p _ i t e m s ] (  
 	 [ l o o k u p _ i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ l o o k u p _ i t e m _ n o ]   [ i n t ]   N O T   N U L L ,  
 	 [ l o o k u p _ i t e m _ i d ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ l o o k u p _ i t e m _ d e s c ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ l o o k u p _ i t e m s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ l o o k u p _ i d ]   A S C ,  
 	 [ l o o k u p _ i t e m _ n o ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m S e t u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m S e t u p ] (  
 	 [ S y s t e m I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ S y s t e m N a m e ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ D e s c r i p t i o n ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ L o g o ]   [ v a r b i n a r y ] ( m a x )   N U L L ,  
 	 [ P h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ F a x ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ E M a i l ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ S y s t e m S t a t u s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ V e r s i o n ]   [ v a r c h a r ] ( 1 0 )   N O T   N U L L ,  
 	 [ R e l e a s e D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ D e f a u l t S a m p l e P l a n ]   [ v a r b i n a r y ] ( m a x )   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m S e t u p ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ S y s t e m I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S y s t e m I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S y s t e m   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S y s t e m N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S y s t e m   I m a g e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o g o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   P h o n e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P h o n e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   F a x '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F a x '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   e m a i l '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E M a i l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S y s t e m   S t a u s ( ' ' 1 ' '   -   p r o d   m o d e ,   ' ' 0 ' '   -   m a i n t   m o d e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S y s t e m S t a t u s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S y s t e m   V e r s i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m S e t u p ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' V e r s i o n '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m C r i t i c a l L e v e l A p p l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m C r i t i c a l L e v e l A p p l ] (  
 	 [ L e v e l I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ L e v e l N o ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ D e s c r ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ L o n g D e s c r ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m C r i t i c a l L e v e l A p p l ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ L e v e l I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L e v e l   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l N o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o n g   D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o n g D e s c r '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m C r i t i c a l L e v e l F u n c ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m C r i t i c a l L e v e l F u n c ] (  
 	 [ L e v e l I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ L e v e l N o ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ D e s c r ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ L o n g D e s c r ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m C r i t i c a l L e v e l F u n c ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ L e v e l I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L e v e l   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l N o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o n g   D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o n g D e s c r '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ u t i l i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ] (  
 	 [ k u _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ U t i l i t y I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ u t i l i t y ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k u _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   f i e l d   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ u t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k u _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ u t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' u t i l i t y   I D   f t o m   A d m i n   t a b l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ u t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U t i l i t y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ u t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ] (  
 	 [ k t m _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ k t _ i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ f i r s t _ n a m e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ l a s t _ n a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ t e a m _ m e m b e r s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k t m _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k t m _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' K e y   T e a m   I D   f r o m   k e _ t e a m s   t a b l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k t _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I D ( i f   t e a m   m e m b e r   p i c k e d   f r o m   d i r e c t o r y ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M e m b e r   f i r s t   n a m e ( s h o u l d   b e   ' ' ' '   i f   U s e r I D   e x i s t ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' f i r s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M e m b e r   l a s t   n a m e ( s h o u l d   b e   ' ' ' '   i f   U s e r I D   e x i s t ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' l a s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' d e s c r i p t i o n   o f   m e m b e r   r e s p o n s i b i l i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m _ m e m b e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' d e s c r i p t i o n '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ] (  
 	 [ p i s _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ I n s t r u c t i o n a l D e p a r t m e n t I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ b _ b S p a c e _ u s a g e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ b S p a c e _ e x p a n d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ b S p a c e _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ b _ b S p a c e _ g r a d e _ u s a g e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ b S p a c e _ g r a d e _ e x p a n d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ b S p a c e _ g r a d e _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ b _ g s i _ c o m m u n i c a t i o n _ u s a g e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ g s i _ c o m m u n i c a t i o n _ e x p a n d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ g s i _ c o m m u n i c a t i o n _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ b _ c o m m o n _ m a t e r i a l s _ u s a g e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ c o m m o n _ m a t e r i a l s _ e x p a n d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b _ c o m m o n _ m a t e r i a l s _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ c _ p r i o r i t i z e _ c o u r s e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c _ p r i o r i t i z e _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ c _ c o m m u n i c a t i o n ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c _ c o m m u n i c a t i o n _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ c _ b a c k u p _ p e r s o n n e l ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c _ b a c k u p _ p e r s o n n e l _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ c _ f a c u l t y _ r e c a l l ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c _ f a c u l t y _ r e c a l l _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ c _ p e d a g o g y ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c _ p e d a g o g y _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n s _ i n s t r u c t i o n s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ p i s _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i s _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t r u c t i o n a l   D e p a r t m e n t   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t r u c t i o n a l D e p a r t m e n t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' b _ b S p a c e _ u s a g e   ( ' ' 1 ' ' = N o n e , ' ' 2 ' ' = S o m e   c o u r s e s , ' ' 3 ' ' = M a n y   c o u r s e s , ' ' 4 ' ' = A l l   c o u r s e s , ' ' 5 ' ' = N o t   s u r e ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ u s a g e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( 1 = Y e s , 2 = N o , 3 = M a y b e ;   d e f a u l t = 0 ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ e x p a n d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = N o n e , ' ' 2 ' ' = S o m e   c o u r s e s , ' ' 3 ' ' = M a n y   c o u r s e s , ' ' 4 ' ' = A l l   c o u r s e s , ' ' 5 ' ' = N o t   s u r e ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ g r a d e _ u s a g e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( 1 = Y e s , 2 = N o , 3 = M a y b e ;   d e f a u l t = 0 ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ g r a d e _ e x p a n d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ b S p a c e _ g r a d e _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = N o n e , ' ' 2 ' ' = S o m e   c o u r s e s , ' ' 3 ' ' = M a n y   c o u r s e s , ' ' 4 ' ' = A l l   c o u r s e s , ' ' 5 ' ' = N o t   s u r e ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ g s i _ c o m m u n i c a t i o n _ u s a g e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( 1 = Y e s , 2 = N o , 3 = M a y b e ;   d e f a u l t = 0 ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ g s i _ c o m m u n i c a t i o n _ e x p a n d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ g s i _ c o m m u n i c a t i o n _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = N o n e , ' ' 2 ' ' = S o m e   c o u r s e s , ' ' 3 ' ' = M a n y   c o u r s e s , ' ' 4 ' ' = A l l   c o u r s e s , ' ' 5 ' ' = N o t   s u r e ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ c o m m o n _ m a t e r i a l s _ u s a g e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( 1 = Y e s , 2 = N o , 3 = M a y b e ;   d e f a u l t = 0 ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ c o m m o n _ m a t e r i a l s _ e x p a n d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b _ c o m m o n _ m a t e r i a l s _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = Y e s , ' ' 2 ' ' = N o , ' ' 3 ' ' = P a r t i a l l y ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ p r i o r i t i z e _ c o u r s e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ p r i o r i t i z e _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = Y e s , ' ' 2 ' ' = N o , ' ' 3 ' ' = P a r t i a l l y ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ c o m m u n i c a t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ c o m m u n i c a t i o n _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = Y e s , ' ' 2 ' ' = N o , ' ' 3 ' ' = P a r t i a l l y ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ b a c k u p _ p e r s o n n e l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ b a c k u p _ p e r s o n n e l _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = Y e s , ' ' 2 ' ' = N o , ' ' 3 ' ' = P a r t i a l l y ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ f a c u l t y _ r e c a l l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ f a c u l t y _ r e c a l l _ c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ( ' ' 1 ' ' = Y e s , ' ' 2 ' ' = N o , ' ' 3 ' ' = P a r t i a l l y ;   d e f a u l t = ' ' 0 ' ' ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ p e d a g o g y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n s _ i n s t r u c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c _ p e d a g o g y _ c o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ] (  
 	 [ i t i _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i s _ i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ i m p a c t ]   [ v a r c h a r ] ( 1 0 2 4 )   N O T   N U L L ,  
 	 [ a l t e r n a t i v e s ]   [ v a r c h a r ] ( 1 0 2 4 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ i t i _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' i t i _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I m p a c t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' i m p a c t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A l t e r n a t i v e s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a l t e r n a t i v e s '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ] (  
 	 [ i h p _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i s _ i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ c o u r s e _ n u m b e r ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ c o u r s e _ t i t l e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ c o u r s e _ c a s t ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ b s p a c e ]   [ b i t ]   N O T   N U L L ,  
 	 [ o t h e r _ c a n _ t e a c h ]   [ b i t ]   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ i h p _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' i d e n t i t y   f i e l d   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' i h p _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' p i s _ i d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i s _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o u r s e   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o u r s e _ n u m b e r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o u r s e   t i t l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o u r s e _ t i t l e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o u r s e   C a s t   ( ' ' 0 ' '   -   d e f a u l t ,   ' ' 1 ' '   -   a v a i l a b l e ,   ' ' 2 ' '   -   a v a i l a b l e   b u t   o u t d a t e d ,   ' ' 3 ' '   -   n o t   a v a i l a b l e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o u r s e _ c a s t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' b S p a c e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b s p a c e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' o t h e r   c a n   t e a c h '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i n s t r u c t i o n _ h i g h _ p r i o r i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' o t h e r _ c a n _ t e a c h '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ c f _ d e p e n d e n c y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ] (  
 	 [ c i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e p e n d e n c y I D ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ c f _ d e p e n d e n c y ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ c i d ]   A S C ,  
 	 [ D e p e n d e n c y I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r i t i c a l   F u n c t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' c f _ d e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p e n d e n c y   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' c f _ d e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p e n d e n c y I D '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ s k i l l s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ s k i l l s ] (  
 	 [ k s _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ S k i l l I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ s k i l l s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k s _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   l e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s k i l l s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k s _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s k i l l s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S k i l l   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s k i l l s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S k i l l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s k i l l s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ] (  
 	 [ k s r _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ c i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ S t a f f C a t e g o r y I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ S h i f t I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ F T E _ n o r m a l ]   [ n u m e r i c ] ( 8 ,   2 )   N O T   N U L L ,  
 	 [ F T E _ c r i s i s ]   [ n u m e r i c ] ( 8 ,   2 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ s t a f f i n g _ r e q ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k s r _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k s r _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r i t i c a l   F u n c t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S t a f f C a t e g o r y I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S t a f f C a t e g o r y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S h i f t   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S h i f t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' F T E   r e q u i r e d   u n d e r   n o r m a l   c o n d i t i o n s   '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F T E _ n o r m a l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' F T E   r e q u i r e d   d u r i n g   c r i s i s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f i n g _ r e q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F T E _ c r i s i s '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ w o r k _ h o m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ] (  
 	 [ w h _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c u r r e n t l y _ d o e s ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ o f f i c e _ p c _ m u s t _ o n ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ i n s t i t u t i o n _ p o s i t i o n ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ b r o a d b a n d _ c o n n e c t i o n ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ o l d _ w h _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ p k _ w h _ i d ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ w h _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C u r r e n t l y   d o e s   c o n n e c t   f r o m   h o m e   I D ( ' ' 1 ' '   -   y e s ,   ' ' 2 ' '   -   p r o b a b l y ,   ' ' 3 ' '   -   p r o b a b l y   n o t ,   ' ' 4 ' '   -   D o n ' ' t   k n o w '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ w o r k _ h o m e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c u r r e n t l y _ d o e s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M u s t   h i s / h e r   o f f i c e   c o m p u t e r   b e   r u n n i n g   ( ' ' 1 ' '   -   Y e s ,   ' ' 2 ' '   -   N o ,   ' ' 3 ' '   -   D o n ' ' t   k n o w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ w o r k _ h o m e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' o f f i c e _ p c _ m u s t _ o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' p o s i t i o n   ( ' ' 1 ' '   -   F a c u l t y ,   ' ' 2 ' '   -   S t a f f ,   ' ' 3 ' '   -   O t h e r ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ w o r k _ h o m e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' i n s t i t u t i o n _ p o s i t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' b r o a d b a n d   c o n n e c t i o n   ( ' ' 1 ' '   -     y e s ,   ' ' 2 ' '   -   N o ,   ' ' 3 ' '   -   P r o b a b l y ,   ' ' 4 ' '   -   P r o b a b l y   n o t ,   ' ' 5 ' '   -   D o n ' ' t   k n o w '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ w o r k _ h o m e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b r o a d b a n d _ c o n n e c t i o n '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ u s e r _ p l a n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ u s e r _ p l a n ] (  
 	 [ u i d ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ P l a n A c c e s s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ A d d e d D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ P l a n C r e a t o r F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I d   f r o m   U s e r S e c u r i t y   T a b l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' u s e r _ p l a n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   A c c e s s (   ' ' 2 ' '   -   m o d i f y ,   ' ' 3 ' '   -   v i e w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' u s e r _ p l a n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n A c c e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   a d d e d   t o   p l a n   d a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' u s e r _ p l a n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A d d e d D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   C r e a t o r   f l a g ( ' ' 1 ' '   -   c r e a t o r ,   ' ' 0 ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' u s e r _ p l a n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n C r e a t o r F l a g '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ] (  
 	 [ k p d _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 8 0 )   N O T   N U L L ,  
 	 [ o w n e r _ d e p a r t m e n t ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ o r i g i n a l _ f i l e _ n a m e ]   [ v a r c h a r ] ( 1 2 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n _ k e p t ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ v a r c h a r ] ( 8 0 0 )   N O T   N U L L ,  
 	 [ m e d i u m I D ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ c o n t a c t s ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ b a c k u p _ m e a s u r e s ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ u p l o a d e d _ f i l e ]   [ v a r b i n a r y ] ( m a x )   N U L L ,  
 	 [ o l d _ k p d _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ d o c u m e n t s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k p d _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M e d i u m   I D   ( l i n k e d   t o   D o c u m e n t M e d i u m   i n   D e s c r i p t i o n L o o k u p   t a b l e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ p l a n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' m e d i u m I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n t a c t s ( m a y   n e e d   s e p a r a t e   t a b l e   t o   k e e p   U s e r I d s   f o r   c o n t a c t s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ p l a n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o n t a c t s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' b a c k u p _ m e a s u r e s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ p l a n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b a c k u p _ m e a s u r e s '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n _ c o n t a c t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ] (  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ C o n t a c t C o m m e n t ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ C o n t a c t T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ A d d e d D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ C o n t a c t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n _ c o n t a c t s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ C o n t a c t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ c o n t a c t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n t a c t   U s e r I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ c o n t a c t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n t a c t   C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ c o n t a c t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o n t a c t C o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n t a c t   T y p e ( ' ' 1 ' '   -   p r i m a r y ,   ' ' 0 ' '   -   n o t   p r i m a r y )   P l a n   c r e a t o r   b e c o m e s   p r i m a r y   b y   d e f a u l t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ c o n t a c t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o n t a c t T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n a c t   A d d e d   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ c o n t a c t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A d d e d D a t e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ s t a f f _ u n i t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ] (  
 	 [ k s u _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ f i r s t _ n a m e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ l a s t _ n a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ v a r c h a r ] ( 2 0 0 )   N O T   N U L L ,  
 	 [ s p e c i a l _ s k i l l ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ t i t l e _ o r _ f u n c t i o n ]   [ v a r c h a r ] ( 2 5 8 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ f i r s t _ s u c c e s s o r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ s e c o n d _ s u c c e s s o r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ t h i r d _ s u c c e s s o r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ h o l d s _ f o r m a l _ d e l e g a t i o n ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ k s u _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ s t a f f _ u n i t ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k s u _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' f i r s t   s u c c e s s o r   ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   u n c h e c k e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f _ u n i t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' f i r s t _ s u c c e s s o r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' s e c o n d   s u c c e s s o r   ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   u n c h e c k e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f _ u n i t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' s e c o n d _ s u c c e s s o r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' t h i r d   s u c c e s s o r   ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   u n c h e c k e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f _ u n i t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' t h i r d _ s u c c e s s o r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' h o l d s _ f o r m a l _ d e l e g a t i o n   ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   u n c h e c k e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a f f _ u n i t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' h o l d s _ f o r m a l _ d e l e g a t i o n '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ i t _ s e r v e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ i t _ s e r v e r s ] (  
 	 [ i t _ s e r v e r _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ t y p e _ s e r v e r ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ e x p l a n a t i o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ b a c k u p _ f r e q u e n c y ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ b a c k u p _ m e d i a ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ a u t o _ m a n u a l ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n _ o n s i t e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ l o c a t i o n _ o f f s i t e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ f r e q u e n c y _ o f f s i t e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ s u c c e s s f u l _ r e c o v e r y ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ a p p s _ i m p a c t e d ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d e p t s _ i m p a c t e d ]   [ t e x t ]   N O T   N U L L ,  
 	 [ s e r v e r _ s o f t w a r e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ t e c h ]   [ t e x t ]   N O T   N U L L ,  
 	 [ r e s p o n s i b l e _ p e r s o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ l o c a t i o n _ d i s k s _ d o c s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ o l d _ i t _ s e r v e r _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ i t _ s e r v e r s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ i t _ s e r v e r _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ] (  
 	 [ R e c o r d I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ C r i t i c a l i t y L e v e l ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ C e n t r a l A p p l i c a t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ C o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ i t _ c e n t r a l _ a p p l i c a t i o n s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ R e c o r d I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ i t _ c e n t r a l _ a p p l i c a t i o n s ]   O N   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]    
 (  
 	 [ p i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e c o r d I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A p p l i c a t i o n   N a m e ( m a y   n e v e r   b e   u s e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r i t i c a l i t y   L e v e l ( ' ' 0 ' '   -   n o t   c r i t i c a l , ' ' 1 ' '   l e v e l   1 , ' ' 2 ' '   l e v e l   2 , ' ' 3 ' '   l e v e l   3 , ' ' 4 ' '   -   l e v e l   4 ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C r i t i c a l i t y L e v e l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C e n t r a l   A p p l i c a t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C e n t r a l A p p l i c a t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' i t _ c e n t r a l _ a p p l i c a t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ i t _ a p p l i c a t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ] (  
 	 [ i t _ a p p l i c a t i o n _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ f u n c t i o n a l _ o w n e r ]   [ t e x t ]   N O T   N U L L ,  
 	 [ t e c h n i c a l _ o w n e r ]   [ t e x t ]   N O T   N U L L ,  
 	 [ a p p l i c a t i o n _ t y p e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ b a c k u p _ f r e q u e n c y ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n _ d i s k s _ d o c s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ r e s p o n s i b l e _ p e r s o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ t e c h ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d e p t s _ i m p a c t e d ]   [ t e x t ]   N O T   N U L L ,  
 	 [ c a m p u s _ s y s t e m s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d a t a _ f r o m _ c o r e ]   [ v a r c h a r ] ( 1 0 )   N O T   N U L L ,  
 	 [ t r a n s a c t i o n _ p r o c e s s i n g ]   [ v a r c h a r ] ( 1 0 )   N O T   N U L L ,  
 	 [ b a c k u p _ m e d i a ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ a u t o _ m a n u a l ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n _ o n s i t e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ l o c a t i o n _ o f f s i t e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ f r e q u e n c y _ o f f s i t e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ s u c c e s s f u l _ r e c o v e r y ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ i t _ a p p l i c a t i o n _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ i t ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ i t _ a p p l i c a t i o n _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ t e a m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ t e a m s ] (  
 	 [ k t _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ t e a m _ n a m e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ t e a m _ p u r p o s e ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ t e a m _ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ t e a m s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k t _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k t _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' t e a m _ n a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' t e a m _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' t e a m _ p u r p o s e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' t e a m _ p u r p o s e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' t e a m   c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ t e a m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' t e a m _ c o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ] (  
 	 [ k _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ k e y _ c o m m _ p r o m p t ]   [ c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ k _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ c o m m u n i c a t i o n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ] (  
 	 [ U n i t H e a d I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ U n i t H e a d C o m m e n t ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ C r e a t e d D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n _ u n i t _ h e a d s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ U n i t H e a d I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ u n i t _ h e a d s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U n i t H e a d I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ u n i t _ h e a d s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ u n i t _ h e a d s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ u n i t _ h e a d s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U n i t H e a d C o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D a t e   C r e a t e d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ u n i t _ h e a d s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C r e a t e d D a t e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ] (  
 	 [ k s _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ f i r s t _ n a m e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ l a s t _ n a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ d e p t ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ a d d r e s s ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ e m a i l ]   [ v a r c h a r ] ( 8 0 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ w o r k _ p h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ c e l l _ p h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ f a x ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ a l t e r n a t e _ v e n d o r s ]   [ v a r c h a r ] ( 2 5 5 )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ s t a k e h o l d e r _ t y p e ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ p r o d u c t _ s e r v i c e ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ o l d _ k s _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ s t a k e h o l d e r s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k s _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k s _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' F i r s t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' f i r s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L a s t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' l a s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t / C o m p a n y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' d e p t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A d d r e s s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a d d r e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' e m a i l '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' e m a i l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D i s a b l e d   ( ' ' Y ' '   -   y e s ,   ' ' N ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' d i s a b l e d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S t a k e h o l d e r   T y p e   ( ' ' 1 ' '   -   c l i e n t ,   ' ' 2 ' '   -   d o n o r ,   ' ' 3 ' '   -   s p o n s o r ,   ' ' 4 ' '   -   v e n d o r ,   ' ' 5 ' '   -   p r o j e c t   p a r t n e r , ' ' 6 ' '   -     o t h e r   s t a k e h o l d e r ,   ' ' 7 ' '   -   o t h e r ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' s t a k e h o l d e r _ t y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r o d u c t   S e r v i c e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ s t a k e h o l d e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p r o d u c t _ s e r v i c e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ] (  
 	 [ k s o _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ f i r s t _ n a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ l a s t _ n a m e ]   [ v a r c h a r ] ( 3 0 )   N O T   N U L L ,  
 	 [ d e p t ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ a d d r e s s ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ e m a i l ]   [ v a r c h a r ] ( 8 0 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ w o r k _ p h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ c e l l _ p h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ f a x ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ k s o _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ s t a f f _ o t h e r _ u n i t s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k s o _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ a c t i o n _ i t e m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ] (  
 	 [ a _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ c i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ a _ t y p e ]   [ v a r c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 6 1 2 )   N O T   N U L L ,  
 	 [ c o s t ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ c o s t _ i s ]   [ v a r c h a r ] ( 2 5 )   N O T   N U L L ,  
 	 [ s c o p e ]   [ v a r c h a r ] ( 2 5 8 )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ s t a t u s ]   [ v a r c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ a _ i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ p i s _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ a c t i o n _ i t e m s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ a _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' ' ' I ' '   i s   f o r   a c t i o n   i t e m   f r o m   I T ,   ' ' G ' '   i s   a c t i o n   i t e m   f r o m   f a c u l t y   p r e p a r e d n e s s ,   ' ' ' '   i s   f o r   c r i t i c a l   f u n c t i o n   A N D   a l l   o t h e r   t y p e   o f   a c t i o n   i t e m s . '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' a c t i o n _ i t e m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' a _ t y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' a c t i o n _ i t e m s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ] (  
 	 [ c i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 1 2 8 )   N O T   N U L L ,  
 	 [ C r i t i c a l i t y L e v e l ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ p r i o r i t y ]   [ i n t ]   N O T   N U L L ,  
 	 [ u n i t _ p e r f o r m s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ r e s p o n s i b l e _ p e r s o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ p e a k _ j a n ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ f e b ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ m a r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ a p r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ m a y ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ j u n ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ j u l ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ a u g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ s e p ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ o c t ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ n o v ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ p e a k _ d e c ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ e x p l a n a t i o n ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ s p a c e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ e q u i p m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ s t a f f ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ u n i q u e _ s k i l l s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ w o r k _ a t _ h o m e ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ n e t w o r k _ a c c e s s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ s h o w _ s t o p p e r s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ c a m p u s _ c l o s u r e ]   [ v a r c h a r ] ( 1 0 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ r i s k ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ p o l i c y _ e x c e p t i o n s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ h o w _ t i m i n g ]   [ v a r c h a r ] ( 8 0 )   N O T   N U L L ,  
 	 [ h o w _ a d d i t i o n a l _ v u l n e r a b i l i t i e s ]   [ t e x t ]   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ t e a c h i n g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ t e a c h i n g _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ r e s e a r c h ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ r e s e a r c h _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ f a c u l t y ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ f a c u l t y _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ s t a f f ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ s t a f f _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ s t u d e n t s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ s t u d e n t s _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ w e l l _ b e i n g _ s t a f f ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ w e l l _ b e i n g _ s t a f f _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ w e l l _ b e i n g _ s t u d e n t s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ w e l l _ b e i n g _ s t u d e n t s _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ p a y m e n t _ d e a d l i n e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ p a y m e n t _ d e a d l i n e _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ r e v e n u e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l o s s _ r e v e n u e _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l e g a l _ o b l i g a t i o n s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l e g a l _ o b l i g a t i o n s _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ l e g a l _ h a r m ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ l e g a l _ h a r m _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ i m p a c t _ o t h e r _ c a m p u s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ i m p a c t _ o t h e r _ c a m p u s _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ i m p a c t _ b u s i n e s s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ i m p a c t _ b u s i n e s s _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ o t h e r ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ o t h e r _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ p a t i e n t c a r e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n ]   [ v a r c h a r ] ( 3 0 0 )   N O T   N U L L ,  
 	 [ d i s a b l e d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ o l d _ c i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ c r i t i c a l _ f u n c t i o n s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ c i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]   T E X T I M A G E _ O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r i t i c a l i t y L e v e l   c o r r e s p o n d s   v a l u e   i n   d e s c r i p t i o n L o o k u p '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' c r i t i c a l _ f u n c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C r i t i c a l i t y L e v e l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o n _ d i s r u p t i o n _ p a t i e n t c a r e ( ' ' 1 ' '   -   c h e c k e d ,   ' ' 0 ' '   -   n o t ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' c r i t i c a l _ f u n c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o n _ d i s r u p t i o n _ p a t i e n t c a r e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' c r i t i c a l _ f u n c t i o n s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n _ b u i l d i n g s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ] (  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ B u i l d i n g I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ B u i l d i n g C o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n _ b u i l d i n g s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ p i d ]   A S C ,  
 	 [ B u i l d i n g I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   C o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ b u i l d i n g s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g C o m m e n t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ P l a n n e r L o g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ P l a n n e r L o g ] (  
 	 [ P l a n n e r L o g I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ P l a n n e r C a t e g o r y I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e s c r i p t i o n ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ N o t e ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ A l e r t F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ A l e r t S t a r t D a t e ]   [ d a t e t i m e ]   N U L L ,  
 	 [ A l e r t E n d D a t e ]   [ d a t e t i m e ]   N U L L ,  
 	 [ A l e r t P e r i o d ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ A l e r t L i s t ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ C r e a t e D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ P l a n n e r L o g ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ P l a n n e r L o g I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ P l a n n e r L o g ]   O N   [ d b o ] . [ P l a n n e r L o g ]    
 (  
 	 [ p i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   F i e l d   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n n e r L o g I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n n e r   C a t e g o r y   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n n e r C a t e g o r y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' d e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r i p t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N o t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N o t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A l e r t   F l a g ( ' ' 0 ' '   -   n o ,   ' ' 1 ' '   -   y e s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A l e r t F l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A l e r t   S t a r t   d a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A l e r t S t a r t D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A l e r t   E n d   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A l e r t E n d D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A l e r t   P e r i o d ( ' ' 1 ' '   -   o n e   t i m e ,   ' ' 2 ' '   -   w e e k l y ,   ' ' 3 ' '   -   m o n h l y ,   ' ' 4 ' '   -   q u a t e r l y ,   ' ' 5 ' '   -   y e a r l y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A l e r t P e r i o d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L i s t   o f   a c c o u n t s   I D   s e p a r a t e d   b y   c o m m a '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A l e r t L i s t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C r a t e   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r L o g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C r e a t e D a t e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n _ r e v i e w e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ] (  
 	 [ p r _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ r e v i e w _ t y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ f i r s t _ n a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ l a s t _ n a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ r e v i e w _ d a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ h e a d _ o r _ d e s i g n e e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ e n t e r _ b y ]   [ i n t ]   N O T   N U L L ,  
 	 [ e n t e r _ d a t e _ t i m e ]   [ d a t e t i m e ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n _ r e v i e w e r s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ p r _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p r _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' p l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' r e v i e w   t y p e   ( ' ' A ' '   -   a n n u a l   r e v i e w ,   ' ' C ' '   -   c o m p l e t e   r e v e i w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' r e v i e w _ t y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' f i r s t   n a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' f i r s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' l a s t   n a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' l a s t _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' r e v i e w   d a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' r e v i e w _ d a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' H e a d   o r   D e s i g n e e   ( ' ' H ' '   -   h e a d ,   ' ' D ' '   -   d e s i g n e e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' h e a d _ o r _ d e s i g n e e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I D   r e c o r d   c r e a t e d   b y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' e n t e r _ b y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D a t e   a n d   t i m e   r e c o r d   c r e a t e d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ r e v i e w e r s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' e n t e r _ d a t e _ t i m e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ] (  
 	 [ p i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e p a r t m e n t T y p e I D ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ p l a n _ d e p a r t m e n t _ t y p e s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ p i d ]   A S C ,  
 	 [ D e p a r t m e n t T y p e I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ d e p a r t m e n t _ t y p e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' p i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t T y p e   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' p l a n _ d e p a r t m e n t _ t y p e s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t T y p e I D '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ R e f e r e n c e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ R e f e r e n c e ] (  
 	 [ R e f e r e n c e I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ R e f e r e n c e ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ R e f e r e n c e ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ R e f e r e n c e I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   N O N C L U S T E R E D   I N D E X   [ I X _ R e f e r e n c e ]   O N   [ d b o ] . [ R e f e r e n c e ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' R e f e r e n c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e f e r e n c e I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' R e f e r e n c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e f e r e n c e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' R e f e r e n c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e f e r e n c e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e f e r e n c e   P r i o r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' R e f e r e n c e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ F A Q ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ F A Q ] (  
 	 [ F A Q I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ Q u e s t i o n ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ A n s w e r ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ F A Q ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ F A Q I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ F A Q ]   O N   [ d b o ] . [ F A Q ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F A Q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F A Q I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F A Q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' Q u e s t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F A Q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' Q u e s t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A n s w e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F A Q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A n s w e r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i o r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F A Q ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n U I I m a g e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I I m a g e ] (  
 	 [ U I I m a g e I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ U I I m a g e ]   [ v a r b i n a r y ] ( m a x )   N O T   N U L L ,  
 	 [ U I I m a g e T y p e ]   [ v a r c h a r ] ( 1 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m D o m a i n U I I m a g e ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ U I I m a g e I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   U N I Q U E   N O N C L U S T E R E D   I N D E X   [ I X _ S y s t e m D o m a i n U I I m a g e ]   O N   [ d b o ] . [ S y s t e m D o m a i n U I I m a g e ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C ,  
 	 [ N a m e ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I I m a g e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I I m a g e I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I I m a g e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I I m a g e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U I   I m a g e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I I m a g e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I I m a g e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U I   I m a g e   T y p e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I I m a g e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I I m a g e T y p e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n U I T e x t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I T e x t ] (  
 	 [ U I T e x t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ U I T e x t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m D o m a i n U I T e x t ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ U I T e x t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   U N I Q U E   N O N C L U S T E R E D   I N D E X   [ I X _ S y s t e m D o m a i n U I T e x t ]   O N   [ d b o ] . [ S y s t e m D o m a i n U I T e x t ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C ,  
 	 [ N a m e ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I T e x t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U I   T e x t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n U I T e x t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U I T e x t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ B u i l d i n g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ B u i l d i n g ] (  
 	 [ B u i l d i n g I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ C A A N ]   [ v a r c h a r ] ( 5 )   N O T   N U L L ,  
 	 [ B u i l d i n g N a m e ]   [ v a r c h a r ] ( 5 0 )   N U L L ,  
 	 [ B u i l d i n g C o m m o n N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ B u i l d i n g A d d r e s s ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ O w n e r s h i p ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ B u i l d i n g ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ B u i l d i n g I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ B u i l d i n g ]   O N   [ d b o ] . [ B u i l d i n g ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C A A N   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C A A N '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   C o m m o n   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g C o m m o n N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' B u i l d i n g   A d d r e s s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' B u i l d i n g A d d r e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O w n e r s h i p ( ' ' 1 ' '   -   o w n e d , ' ' 0 ' '   -   r e n t e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' B u i l d i n g ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O w n e r s h i p '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ N e t D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ N e t D o m a i n ] (  
 	 [ N e t D o m a i n I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ N e t D o m a i n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ N e t D o m a i n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' N e t D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N e t D o m a i n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D o m a i n   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' N e t D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' N e t D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ] (  
 	 [ L e v e l I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ L e v e l N o ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ D e s c r ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ L o n g D e s c r ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ L e v e l I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   U N I Q U E   N O N C L U S T E R E D   I N D E X   [ I X _ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]   O N   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C ,  
 	 [ L e v e l N o ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L e v e l   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l N o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o n g   D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o n g D e s c r '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ] (  
 	 [ L e v e l I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ L e v e l N o ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ D e s c r ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ L o n g D e s c r ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ L e v e l I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   U N I Q U E   N O N C L U S T E R E D   I N D E X   [ I X _ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]   O N   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C ,  
 	 [ L e v e l N o ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L e v e l   N u m b e r '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L e v e l N o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L o n g   D e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o n g D e s c r '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ T h i n g s T o K n o w ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ] (  
 	 [ T h i n g s T o K n o w I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ T h i n g s T o K n o w I t e m ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ T h i n g s T o K n o w ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ T h i n g s T o K n o w I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ T h i n g s T o K n o w ]   O N   [ d b o ] . [ T h i n g s T o K n o w ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' T h i n g s T o K n o w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T h i n g s T o K n o w I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' T h i n g s T o K n o w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I t e m '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' T h i n g s T o K n o w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T h i n g s T o K n o w I t e m '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i o r i t y ( o r d e r   i n   w h i c h   s h o w   t o   u s e r s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' T h i n g s T o K n o w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ D e p a r t m e n t T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ D e p a r t m e n t T y p e ] (  
 	 [ D e p a r t m e n t T y p e I d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e p a r t m e n t T y p e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ D e p a r t m e n t T y p e ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ D e p a r t m e n t T y p e I d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ D e p a r t m e n t T y p e ]   O N   [ d b o ] . [ D e p a r t m e n t T y p e ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p a r t m e n t T y p e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t T y p e I d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p a r t m e n t T y p e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p a r t m e n t   T y p e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p a r t m e n t T y p e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p a r t m e n t T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p a r t m e n t T y p e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ P l a n n e r C a t e g o r y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ] (  
 	 [ P l a n n e r C a t e g o r y I d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ I t e m ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ P l a n n e r C a t e g o r y ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ P l a n n e r C a t e g o r y I d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ P l a n n e r C a t e g o r y ]   O N   [ d b o ] . [ P l a n n e r C a t e g o r y ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n n e r C a t e g o r y I d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n n e r   C a t e g o r y   I t e m '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I t e m '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i o r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' P l a n n e r C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ] (  
 	 [ C e n t r a l A p p l i c a t i o n I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ R e c o r d T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ C e n t r a l A p p l i c a t i o n ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ C e n t r a l A p p l i c a t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ C e n t r a l A p p l i c a t i o n ]   O N   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C e n t r a l A p p l i c a t i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C e n t r a l A p p l i c a t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C e n t r a l A p p l i c a t i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C e n t r a l   A p p l i c a t i o n / S y s t e m   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C e n t r a l A p p l i c a t i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' r e c o r d   T y p e   ( ' ' S ' '   -   A d m i n   e n t e r e d ,   ' ' U ' '   -   u s e r   e n t e r e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C e n t r a l A p p l i c a t i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e c o r d T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C e n t r a l A p p l i c a t i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ C o n t a c t U s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ C o n t a c t U s ] (  
 	 [ C o n t a c t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ C o n t a c t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ C o n t a c t U s ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ C o n t a c t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ C o n t a c t U s ]   O N   [ d b o ] . [ C o n t a c t U s ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C o n t a c t U s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o n t a c t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C o n t a c t U s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' C o n t a c t   I n f o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C o n t a c t U s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' C o n t a c t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' C o n t a c t U s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ D e p e n d e n c y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ D e p e n d e n c y ] (  
 	 [ D e p e n d e n c y I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ D e p e n d e n c y ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ D e p e n d e n c y T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ R e c o r d T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ D e p e n d e n c y ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ D e p e n d e n c y I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ D e p e n d e n c y ]   O N   [ d b o ] . [ D e p e n d e n c y ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p e n d e n c y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p e n d e n c y   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p e n d e n c y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D e p e n d e n c y   T y p e ( ' ' 1 ' '      u p s t r e a m ,   ' ' 0 ' '      d o w n s t r e a m ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e p e n d e n c y T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e c o r d   T y p e ( ' ' S ' '   -   a d m i n s   a d d e d ,   ' ' U ' '   -   u s e r   a d d e d ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e c o r d T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' D e p e n d e n c y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ A n n u a l R e v i e w ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ] (  
 	 [ A n n u a l R e v i e w I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ R e v i e w I t e m ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ A n n u a l R e v i e w ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ A n n u a l R e v i e w I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ A n n u a l R e v i e w ]   O N   [ d b o ] . [ A n n u a l R e v i e w ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A n n u a l R e v i e w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A n n u a l R e v i e w I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A n n u a l R e v i e w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A n n u a l   R e v i e w '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A n n u a l R e v i e w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e v i e w I t e m '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i o r i r y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A n n u a l R e v i e w ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ A c r o n y m ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ A c r o n y m ] (  
 	 [ A c r o n y m I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ A c r o n y m ]   [ v a r c h a r ] ( 2 5 )   N U L L ,  
 	 [ F u l l N a m e ]   [ v a r c h a r ] ( 6 0 )   N U L L ,  
   C O N S T R A I N T   [ P K _ A c r o n y m ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ A c r o n y m I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ A c r o n y m ]   O N   [ d b o ] . [ A c r o n y m ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' i d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A c r o n y m ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A c r o n y m I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A c r o n y m ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A c r o n y m '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A c r o n y m ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A c r o n y m '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' F u l l   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A c r o n y m ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F u l l N a m e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ U t i l i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ U t i l i t y ] (  
 	 [ U t i l i t y I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ U t i l i t y ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ U t i l i t y I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ U t i l i t y ]   O N   [ d b o ] . [ U t i l i t y ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U t i l i t y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U t i l i t y   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' o r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' U t i l i t y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S t a f f C a t e g o r y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ] (  
 	 [ S t a f f C a t e g o r y I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I d ]   [ i n t ]   N O T   N U L L ,  
 	 [ S t a f f C a t e g o r y ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S t a f f C a t e g o r y ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ S t a f f C a t e g o r y I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ S t a f f C a t e g o r y ]   O N   [ d b o ] . [ S t a f f C a t e g o r y ]    
 (  
 	 [ I n s t i t u t i o n I d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S t a f f C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S t a f f C a t e g o r y I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S t a f f C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S t a f f   C a t e g o r y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S t a f f C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S t a f f C a t e g o r y '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P r i o r i t y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S t a f f C a t e g o r y ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ F u n c t i o n E x a m p l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ F u n c t i o n E x a m p l e ] (  
 	 [ F u n c t i o n E x a m p l e I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ P l a n L i s t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ F u n c t i o n E x a m p l e ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ F u n c t i o n E x a m p l e I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F u n c t i o n E x a m p l e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F u n c t i o n E x a m p l e I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n I d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F u n c t i o n E x a m p l e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P l a n   L i s t   t o   u s e   f u n c t i o n s   f r o m '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' F u n c t i o n E x a m p l e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P l a n L i s t '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S k i l l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S k i l l ] (  
 	 [ S k i l l I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ D e s c r i p t i o n ]   [ v a r c h a r ] ( 4 0 0 )   N O T   N U L L ,  
 	 [ R e c o r d T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S k i l l ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ S k i l l I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ S k i l l ]   O N   [ d b o ] . [ S k i l l ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S k i l l I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S k i l l   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S k i l l   d e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D e s c r i p t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' R e c o r d   t y p e ( ' ' S ' '   -   s y s t e m   a d m i n   r e c o r d e d ,   ' ' U ' '   -   U s e r   r e c o r d e d ' ' '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' R e c o r d T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S k i l l ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ M a j o r D i v i s i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ M a j o r D i v i s i o n ] (  
 	 [ M a j o r D i v i s i o n I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ M a j o r D i v i s i o n N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ D i v i s i o n ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ M a j o r D i v i s i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ D i v i s i o n ]   O N   [ d b o ] . [ M a j o r D i v i s i o n ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' M a j o r D i v i s i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' M a j o r D i v i s i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' M a j o r D i v i s i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D i v i s i o n   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' M a j o r D i v i s i o n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' M a j o r D i v i s i o n N a m e '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S h i f t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S h i f t ] (  
 	 [ S h i f t I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   N O T   N U L L ,  
 	 [ N a m e ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ O r d e r N o ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ S h i f t ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ S h i f t I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 C R E A T E   C L U S T E R E D   I N D E X   [ I X _ S h i f t ]   O N   [ d b o ] . [ S h i f t ]    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   S O R T _ I N _ T E M P D B   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   D R O P _ E X I S T I N G   =   O F F ,   O N L I N E   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S h i f t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S h i f t I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S h i f t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S h i f t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S h i f t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r d e r   N o '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S h i f t ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' O r d e r N o '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ] (  
 	 [ I n s t i t u t i o n I D ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n O r g L i s t ]   [ v a r c h a r ] ( 2 0 0 0 )   N O T   N U L L ,  
 	 [ A u t h L o c a t i o n ]   [ v a r c h a r ] ( 1 0 2 4 )   N O T   N U L L ,  
 	 [ A u t h T y p e ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ D o m a i n ]   [ i n t ]   N O T   N U L L ,  
 	 [ N e w s ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ N e w s E x p i r a t i o n D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ T i p s ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ T i p s E x p i r a t i o n D a t e ]   [ d a t e t i m e ]   N O T   N U L L ,  
 	 [ L o g o ]   [ v a r b i n a r y ] ( m a x )   N U L L ,  
 	 [ P h o n e ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ F a x ]   [ v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ E M a i l ]   [ v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ I n s t i t u t i o n A c c e s s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ D i r e c t o r y A c c e s s ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ T e a m s S c r e e n F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ S k i l l s S c r e e n F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ S t a f f i n g S c r e e n F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ E x a m p l e s S c r e e n F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ L B N L F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L ,  
 	 [ S a m p l e P l a n ]   [ v a r b i n a r y ] ( m a x )   N U L L  
 )   O N   [ P R I M A R Y ]  
 S E T   A N S I _ P A D D I N G   O F F  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ R e p l a c e S t e p 4 F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ I n s t r u c t i o n _ U R L ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ I n s t G r o u p I D ]   [ i n t ]   N U L L  
 S E T   A N S I _ P A D D I N G   O N  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ I n s t G r o u p ]   [ v a r c h a r ] ( 5 0 )   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ S y s t e m N a m e ]   [ v a r c h a r ] ( 1 0 0 )   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ M o d e r a t i o n ]   [ c h a r ] ( 1 )   N U L L  
 S E T   A N S I _ P A D D I N G   O F F  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ C u s t o m U r l ]   [ v a r c h a r ] ( 1 0 0 )   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ S h i b U n i q u e I D ]   [ v a r c h a r ] ( 1 0 0 )   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D   [ C r i t i c a l L v l D t l s F l a g ]   [ c h a r ] ( 1 )   N O T   N U L L  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ P K _ S y s t e m D o m a i n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ I n s t i t u t i o n I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I d e n t i t y   K e y '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   T y p e ( ' ' 0 ' '   -   P r i m a r y , ' ' 1 ' '   -   M e m b e r ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   O r g   L i s t ( u s e d   f o r   m e m b e r   i n s t i t u t i o n s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n O r g L i s t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A u t h   L o c a t i o n ( P r i m a r y   l o c a t i o n   i d i e n t i f i e r   r e c e i v e d   a f t e r   a u t h e n t i c a t i o n )   ( ' ' ' '   f o r   m e m b e r   i n s t i t u t i o n s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A u t h L o c a t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' A u t h T y p e ( ' ' 0 ' '   -   s e c u r i t y   p r o v i d e d   b y   U C R e a d y   p a s s w o r d ,   ' ' 1 ' '   - c o m m o n t   a u t h   m e t h o d ( s h i b ) ,   ' ' 2 ' '   -   i n d i v i d u a l     s e c u r i t y   p r o v i d e d   b y   i n s t i t u t i o n   l o c a l   a u t h ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' A u t h T y p e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D o m a i n ( I n s t i t u t i o n   I D   p r o v i d i n g   I D P ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D o m a i n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   N e w s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N e w s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' N e w s   E x p i r a t i o n   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' N e w s E x p i r a t i o n D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   T i p s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T i p s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' T i p s   E x p i r a t i o n   D a t e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T i p s E x p i r a t i o n D a t e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   I m a g e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L o g o '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   P h o n e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' P h o n e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   F a x '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' F a x '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S u p p o r t   E M a i l '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E M a i l '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' I n s t i t u t i o n   A c c e s s (   ' ' 0 ' '   - S y s t e m   A d m i n i s t r a t o r s ,   ' ' 1 ' '   -   l o c a l   A d m i n i s t r a t o r s , ' ' 2 ' ' -   l o c a l   U s e r s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' I n s t i t u t i o n A c c e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' P e o p l e   D i r e c t o r y   A c c e s s ( L D A P / D S )   ( ' ' 1 ' '   -   y e s ,   ' ' 0 ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' D i r e c t o r y A c c e s s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' T e a m s   S c r e e n   F l a g ( 1 -   s h o w   T e a m s   s c r e e n ,   0      n o   s h o w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' T e a m s S c r e e n F l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S k i l l s   S c r e e n   F l a g ( 1 -   s h o w   S k i l l s   s c r e e n ,   0      n o   s h o w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S k i l l s S c r e e n F l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' S t a f f i n g   S c r e e n   F l a g ( 1 -   s h o w   S t a f f i n g   s c r e e n ,   0      n o   s h o w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' S t a f f i n g S c r e e n F l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' E x a m p l e s   S c r e e n   F l a g ( 1 -   s h o w   E x a m p l e s   s c r e e n ,   0      n o   s h o w ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' E x a m p l e s S c r e e n F l a g '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' L B N L   F l a g ( ' ' 1 ' '   -   y e s ,   ' ' 0 ' '   -   n o ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' S y s t e m D o m a i n ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' L B N L F l a g '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ A d m i n T e s t M o d e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ A d m i n T e s t M o d e ] (  
 	 [ U s e r I D ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ A d m i n T e s t M o d e ]   P R I M A R Y   K E Y   N O N C L U S T E R E D    
 (  
 	 [ U s e r I D ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' U s e r   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' A d m i n T e s t M o d e ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' U s e r I D '  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 S E T   A N S I _ P A D D I N G   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ] (  
 	 [ k c d _ i d ]   [ i n t ]   I D E N T I T Y ( 1 , 1 )   N O T   N U L L ,  
 	 [ c i d ]   [ i n t ]   N O T   N U L L ,  
 	 [ n a m e ]   [ v a r c h a r ] ( 8 0 )   N O T   N U L L ,  
 	 [ o w n e r _ d e p a r t m e n t ]   [ v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ o r i g i n a l _ f i l e _ n a m e ]   [ v a r c h a r ] ( 1 2 0 )   N O T   N U L L ,  
 	 [ l o c a t i o n _ k e p t ]   [ v a r c h a r ] ( 2 5 6 )   N O T   N U L L ,  
 	 [ c o m m e n t ]   [ v a r c h a r ] ( m a x )   N O T   N U L L ,  
 	 [ d e s c r i p t i o n ]   [ v a r c h a r ] ( 8 0 0 )   N O T   N U L L ,  
 	 [ m e d i u m I D ]   [ v a r c h a r ] ( 2 )   N O T   N U L L ,  
 	 [ c o n t a c t s ]   [ v a r c h a r ] ( 1 0 2 4 )   N O T   N U L L ,  
 	 [ b a c k u p _ m e a s u r e s ]   [ v a r c h a r ] ( 5 1 2 )   N O T   N U L L ,  
 	 [ u p l o a d e d _ f i l e ]   [ v a r b i n a r y ] ( m a x )   N U L L ,  
 	 [ o l d _ k c d _ i d ]   [ i n t ]   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ k c d _ i d ]   A S C  
 ) W I T H   ( P A D _ I N D E X     =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E     =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S     =   O N ,   A L L O W _ P A G E _ L O C K S     =   O N )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 S E T   A N S I _ P A D D I N G   O F F  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' i d e n t i t y   k e y   f o r   t h e   r e c o r d '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' k c d _ i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c r r i t i c a l   f u n c t i o n   I D '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c i d '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' D o c u m e n t   N a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O w n e r   D e p a r t m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' o w n e r _ d e p a r t m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' O r i g i n a l   f i l e   n a m e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' o r i g i n a l _ f i l e _ n a m e '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' l o c a t i o n   k e p t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' l o c a t i o n _ k e p t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o m m e n t '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o m m e n t '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' d e s c r i p t i o n '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' d e s c r i p t i o n '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' M e d i u m   I D   ( l i n k e d   t o   D o c u m e n t M e d i u m   i n   D e s c r i p t i o n L o o k u p   t a b l e ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' m e d i u m I D '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' c o n t a c t s ( m a y   n e e d   s e p a r a t e   t a b l e   t o   s t o r e   u s e r   i d ' ' s ) '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' c o n t a c t s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' b a c k u p   m e a s u r e s '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' b a c k u p _ m e a s u r e s '  
 G O  
 E X E C   s y s . s p _ a d d e x t e n d e d p r o p e r t y   @ n a m e = N ' M S _ D e s c r i p t i o n ' ,   @ v a l u e = N ' u p l o a d e d   f i l e '   ,   @ l e v e l 0 t y p e = N ' S C H E M A ' , @ l e v e l 0 n a m e = N ' d b o ' ,   @ l e v e l 1 t y p e = N ' T A B L E ' , @ l e v e l 1 n a m e = N ' k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ' ,   @ l e v e l 2 t y p e = N ' C O L U M N ' , @ l e v e l 2 n a m e = N ' u p l o a d e d _ f i l e '  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ s e t p r o p e r t y b y i d _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 / *  
 * * 	 I f   t h e   p r o p e r t y   a l r e a d y   e x i s t s ,   r e s e t   t h e   v a l u e ;   o t h e r w i s e   a d d   p r o p e r t y  
 * * 	 	 i d   - -   t h e   i d   i n   s y s o b j e c t s   o f   t h e   o b j e c t  
 * * 	 	 p r o p e r t y   - -   t h e   n a m e   o f   t h e   p r o p e r t y  
 * * 	 	 u v a l u e   - -   t h e   t e x t   v a l u e   o f   t h e   p r o p e r t y  
 * * 	 	 l v a l u e   - -   t h e   b i n a r y   v a l u e   o f   t h e   p r o p e r t y   ( i m a g e )  
 * /  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ s e t p r o p e r t y b y i d _ u ]  
 	 @ i d   i n t ,  
 	 @ p r o p e r t y   v a r c h a r ( 6 4 ) ,  
 	 @ u v a l u e   n v a r c h a r ( 2 5 5 ) ,  
 	 @ l v a l u e   i m a g e  
 a s  
 	 s e t   n o c o u n t   o n  
 	 - -    
 	 - -   I f   w e   a r e   w r i t i n g   t h e   n a m e   p r o p e r t y ,   f i n d   t h e   a n s i   e q u i v a l e n t .    
 	 - -   I f   t h e r e   i s   n o   l o s s l e s s   t r a n s l a t i o n ,   g e n e r a t e   a n   a n s i   n a m e .    
 	 - -    
 	 d e c l a r e   @ a v a l u e   v a r c h a r ( 2 5 5 )    
 	 s e t   @ a v a l u e   =   n u l l    
 	 i f   ( @ u v a l u e   i s   n o t   n u l l )    
 	 b e g i n    
 	 	 i f   ( c o n v e r t ( n v a r c h a r ( 2 5 5 ) ,   c o n v e r t ( v a r c h a r ( 2 5 5 ) ,   @ u v a l u e ) )   =   @ u v a l u e )    
 	 	 b e g i n    
 	 	 	 s e t   @ a v a l u e   =   c o n v e r t ( v a r c h a r ( 2 5 5 ) ,   @ u v a l u e )    
 	 	 e n d    
 	 	 e l s e    
 	 	 b e g i n    
 	 	 	 i f   ' D t g S c h e m a N A M E '   =   @ p r o p e r t y    
 	 	 	 b e g i n    
 	 	 	 	 e x e c   d b o . d t _ g e n e r a t e a n s i n a m e   @ a v a l u e   o u t p u t    
 	 	 	 e n d    
 	 	 e n d    
 	 e n d    
 	 i f   e x i s t s   ( s e l e c t   *   f r o m   d b o . d t p r o p e r t i e s    
 	 	 	 w h e r e   o b j e c t i d = @ i d   a n d   p r o p e r t y = @ p r o p e r t y )  
 	 b e g i n  
 	 	 - -  
 	 	 - -   b u m p   t h e   v e r s i o n   c o u n t   f o r   t h i s   r o w   a s   w e   u p d a t e   i t  
 	 	 - -  
 	 	 u p d a t e   d b o . d t p r o p e r t i e s   s e t   v a l u e = @ a v a l u e ,   u v a l u e = @ u v a l u e ,   l v a l u e = @ l v a l u e ,   v e r s i o n = v e r s i o n + 1  
 	 	 	 w h e r e   o b j e c t i d = @ i d   a n d   p r o p e r t y = @ p r o p e r t y  
 	 e n d  
 	 e l s e  
 	 b e g i n  
 	 	 - -  
 	 	 - -   v e r s i o n   c o u n t   i s   a u t o - s e t   t o   0   o n   i n i t i a l   i n s e r t  
 	 	 - -  
 	 	 i n s e r t   d b o . d t p r o p e r t i e s   ( p r o p e r t y ,   o b j e c t i d ,   v a l u e ,   u v a l u e ,   l v a l u e )  
 	 	 	 v a l u e s   ( @ p r o p e r t y ,   @ i d ,   @ a v a l u e ,   @ u v a l u e ,   @ l v a l u e )  
 	 e n d  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ a d d t o s o u r c e c o n t r o l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ a d d t o s o u r c e c o n t r o l ]  
         @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ v c h P r o j e c t N a m e       v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h C o m m e n t               v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h L o g i n N a m e           v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h P a s s w o r d             v a r c h a r ( 2 5 5 )   = ' '  
  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ i R e t u r n   i n t  
 d e c l a r e   @ i O b j e c t I d   i n t  
 s e l e c t   @ i O b j e c t I d   =   0  
  
 d e c l a r e   @ i S t r e a m O b j e c t I d   i n t  
 s e l e c t   @ i S t r e a m O b j e c t I d   =   0  
  
 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
 d e c l a r e   @ v c h D a t a b a s e N a m e   v a r c h a r ( 2 5 5 )  
 s e l e c t   @ v c h D a t a b a s e N a m e   =   d b _ n a m e ( )  
  
 d e c l a r e   @ i R e t u r n V a l u e   i n t  
 s e l e c t   @ i R e t u r n V a l u e   =   0  
  
 d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
 d e c l a r e   @ v c h P a r e n t I d   v a r c h a r ( 2 5 5 )  
  
 d e c l a r e   @ i O b j e c t C o u n t   i n t  
 s e l e c t   @ i O b j e c t C o u n t   =   0  
  
         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
  
         / *   C r e a t e   P r o j e c t   i n   S S   * /  
         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 ' A d d P r o j e c t T o S o u r c e S a f e ' ,  
 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h P r o j e c t N a m e   o u t p u t ,  
 	 	 	 	 	 	 	 	 	 	 	 @ @ S E R V E R N A M E ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h P a s s w o r d ,  
 	 	 	 	 	 	 	 	 	 	 	 @ v c h C o m m e n t  
  
  
         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
         / *   S e t   D a t a b a s e   P r o p e r t i e s   * /  
  
         b e g i n   t r a n   S e t P r o p e r t i e s  
  
         / *   a d d   h i g h   l e v e l   o b j e c t   * /  
  
         e x e c   @ i P r o p e r t y O b j e c t I d   =   d b o . d t _ a d d u s e r o b j e c t _ v c s   ' V C S P r o j e c t I D '  
  
         s e l e c t   @ v c h P a r e n t I d   =   C O N V E R T ( v a r c h a r ( 2 5 5 ) , @ i P r o p e r t y O b j e c t I d )  
  
         e x e c   d b o . d t _ s e t p r o p e r t y b y i d   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t I D ' ,   @ v c h P a r e n t I d   ,   N U L L  
         e x e c   d b o . d t _ s e t p r o p e r t y b y i d   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t '   ,   @ v c h P r o j e c t N a m e   ,   N U L L  
         e x e c   d b o . d t _ s e t p r o p e r t y b y i d   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I '   ,   @ v c h S o u r c e S a f e I N I   ,   N U L L  
         e x e c   d b o . d t _ s e t p r o p e r t y b y i d   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L S e r v e r ' ,   @ @ S E R V E R N A M E ,   N U L L  
         e x e c   d b o . d t _ s e t p r o p e r t y b y i d   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L D a t a b a s e ' ,   @ v c h D a t a b a s e N a m e ,   N U L L  
  
         i f   @ @ e r r o r   < >   0   G O T O   E _ G e n e r a l _ E r r o r  
  
         c o m m i t   t r a n   S e t P r o p e r t i e s  
          
         s e l e c t   @ i O b j e c t C o u n t   =   0 ;  
  
 C l e a n U p :  
         s e l e c t   @ v c h P r o j e c t N a m e  
         s e l e c t   @ i O b j e c t C o u n t  
         r e t u r n  
  
 E _ G e n e r a l _ E r r o r :  
         / *   t h i s   i s   a n   a l l   o r   n o t h i n g .     N o   s p e c i f i c   e r r o r   m e s s a g e s   * /  
         g o t o   C l e a n U p  
  
 E _ O A E r r o r :  
         e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
         g o t o   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ r e m o v e f r o m s o u r c e c o n t r o l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ r e m o v e f r o m s o u r c e c o n t r o l ]  
  
 a s  
  
         s e t   n o c o u n t   o n  
  
         d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         e x e c   d b o . d t _ d r o p p r o p e r t i e s b y i d   @ i P r o p e r t y O b j e c t I d ,   n u l l  
  
         / *   - 1   i s   r e t u r n e d   b y   d t _ d r o p p o p e r t i e s b y i d   * /  
         i f   @ @ e r r o r   < >   0   a n d   @ @ e r r o r   < >   - 1   r e t u r n   1  
  
         r e t u r n   0  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ v c s _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c e d u r e   [ d b o ] . [ d t _ g e t p r o p e r t i e s b y i d _ v c s _ u ]  
         @ i d               i n t ,  
         @ p r o p e r t y   v a r c h a r ( 6 4 ) ,  
         @ v a l u e         n v a r c h a r ( 2 5 5 )   =   N U L L   O U T  
  
 a s  
  
         - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ g e t p r o p e r t i e s b y i d _ v c s s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ g e t p r o p e r t i e s b y i d _ v c s   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s  
 	 	 @ i d ,  
 	 	 @ p r o p e r t y ,  
 	 	 @ v a l u e   o u t p u t  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ w h o c h e c k e d o u t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ w h o c h e c k e d o u t ]  
                 @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
                 @ v c h O b j e c t N a m e   v a r c h a r ( 2 5 5 ) ,  
                 @ v c h L o g i n N a m e     v a r c h a r ( 2 5 5 ) ,  
                 @ v c h P a s s w o r d       v a r c h a r ( 2 5 5 )  
  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ i R e t u r n   i n t  
 d e c l a r e   @ i O b j e c t I d   i n t  
 s e l e c t   @ i O b j e c t I d   = 0  
  
 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
         d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         d e c l a r e   @ v c h P r o j e c t N a m e       v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S e r v e r N a m e         v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h D a t a b a s e N a m e     v a r c h a r ( 2 5 5 )  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t ' ,               @ v c h P r o j e c t N a m e       O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I ' ,   @ v c h S o u r c e S a f e I N I   O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L S e r v e r ' ,           @ v c h S e r v e r N a m e         O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L D a t a b a s e ' ,       @ v c h D a t a b a s e N a m e     O U T  
  
         i f   @ c h O b j e c t T y p e   =   ' P R O C '  
         b e g i n  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 d e c l a r e   @ v c h R e t u r n V a l u e   v a r c h a r ( 2 5 5 )  
                 s e l e c t   @ v c h R e t u r n V a l u e   =   ' '  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 ' W h o C h e c k e d O u t ' ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h R e t u r n V a l u e   O U T ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s P r o j e c t N a m e   =   @ v c h P r o j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s S o u r c e S a f e I N I   =   @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s O b j e c t N a m e   =   @ v c h O b j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s S e r v e r N a m e   =   @ v c h S e r v e r N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s D a t a b a s e N a m e   =   @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s L o g i n N a m e   =   @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s P a s s w o r d   =   @ v c h P a s s w o r d  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 s e l e c t   @ v c h R e t u r n V a l u e  
  
         e n d  
  
 C l e a n U p :  
         r e t u r n  
  
 E _ O A E r r o r :  
         e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
         G O T O   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ v a l i d a t e l o g i n p a r a m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ v a l i d a t e l o g i n p a r a m s ]  
         @ v c h L o g i n N a m e     v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       v a r c h a r ( 2 5 5 )  
 a s  
  
 s e t   n o c o u n t   o n  
  
 d e c l a r e   @ i R e t u r n   i n t  
 d e c l a r e   @ i O b j e c t I d   i n t  
 s e l e c t   @ i O b j e c t I d   = 0  
  
 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
         d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         d e c l a r e   @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I ' ,   @ v c h S o u r c e S a f e I N I   O U T  
  
         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 ' V a l i d a t e L o g i n P a r a m s ' ,  
 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 @ s S o u r c e S a f e I N I   =   @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 @ s L o g i n N a m e   =   @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 @ s P a s s w o r d   =   @ v c h P a s s w o r d  
         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
 C l e a n U p :  
         r e t u r n  
  
 E _ O A E r r o r :  
         e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
         G O T O   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ i s u n d e r s o u r c e c o n t r o l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ i s u n d e r s o u r c e c o n t r o l ]  
         @ v c h L o g i n N a m e   v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ v c h P a s s w o r d     v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ i W h o T o o             i n t   =   0   / *   0   = >   J u s t   c h e c k   p r o j e c t ;   1   = >   g e t   l i s t   o f   o b j s   * /  
  
 a s  
  
 	 s e t   n o c o u n t   o n  
  
 	 d e c l a r e   @ i R e t u r n   i n t  
 	 d e c l a r e   @ i O b j e c t I d   i n t  
 	 s e l e c t   @ i O b j e c t I d   =   0  
  
 	 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 	 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
 	 d e c l a r e   @ i R e t u r n V a l u e   i n t  
 	 s e l e c t   @ i R e t u r n V a l u e   =   0  
  
 	 d e c l a r e   @ i S t r e a m O b j e c t I d   i n t  
 	 s e l e c t   @ i S t r e a m O b j e c t I d       =   0  
  
 	 d e c l a r e   @ v c h T e m p T e x t   v a r c h a r ( 2 5 5 )  
  
         d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         d e c l a r e   @ v c h P r o j e c t N a m e       v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S e r v e r N a m e         v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h D a t a b a s e N a m e     v a r c h a r ( 2 5 5 )  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t ' ,               @ v c h P r o j e c t N a m e       O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I ' ,   @ v c h S o u r c e S a f e I N I   O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L S e r v e r ' ,           @ v c h S e r v e r N a m e         O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L D a t a b a s e ' ,       @ v c h D a t a b a s e N a m e     O U T  
  
         i f   ( @ v c h P r o j e c t N a m e   =   ' ' ) 	 s e t   @ v c h P r o j e c t N a m e 	 	 =   n u l l  
         i f   ( @ v c h S o u r c e S a f e I N I   =   ' ' )   s e t   @ v c h S o u r c e S a f e I N I 	 =   n u l l  
         i f   ( @ v c h S e r v e r N a m e   =   ' ' ) 	 s e t   @ v c h S e r v e r N a m e 	 	 =   n u l l  
         i f   ( @ v c h D a t a b a s e N a m e   =   ' ' ) 	 s e t   @ v c h D a t a b a s e N a m e 	 =   n u l l  
          
         i f   ( @ v c h P r o j e c t N a m e   i s   n u l l )   o r   ( @ v c h S o u r c e S a f e I N I   i s   n u l l )   o r   ( @ v c h S e r v e r N a m e   i s   n u l l )   o r   ( @ v c h D a t a b a s e N a m e   i s   n u l l )  
         b e g i n  
                 R A I S E R R O R ( ' N o t   U n d e r   S o u r c e   C o n t r o l ' , 1 6 , - 1 )  
                 r e t u r n  
         e n d  
  
         i f   @ i W h o T o o   =   1  
         b e g i n  
  
                 / *   G e t   L i s t   o f   P r o c s   i n   t h e   p r o j e c t   * /  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 ' G e t L i s t O f O b j e c t s ' ,  
 	 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h P r o j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h S e r v e r N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ v c h P a s s w o r d  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A G e t P r o p e r t y   @ i O b j e c t I d ,   ' G e t S t r e a m O b j e c t ' ,   @ i S t r e a m O b j e c t I d   O U T  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 c r e a t e   t a b l e   # O b j e c t L i s t   ( i d   i n t   i d e n t i t y ,   v c h O b j e c t l i s t   v a r c h a r ( 2 5 5 ) )  
  
                 s e l e c t   @ v c h T e m p T e x t   =   ' S T U B '  
                 w h i l e   @ v c h T e m p T e x t   i s   n o t   n u l l  
                 b e g i n  
                         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i S t r e a m O b j e c t I d ,   ' G e t S t r e a m ' ,   @ i R e t u r n V a l u e   O U T ,   @ v c h T e m p T e x t   O U T  
                         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
                          
                         i f   ( @ v c h T e m p T e x t   =   ' ' )   s e t   @ v c h T e m p T e x t   =   n u l l  
                         i f   ( @ v c h T e m p T e x t   i s   n o t   n u l l )   i n s e r t   i n t o   # O b j e c t L i s t   ( v c h O b j e c t l i s t   )   s e l e c t   @ v c h T e m p T e x t  
                 e n d  
  
                 s e l e c t   v c h O b j e c t l i s t   f r o m   # O b j e c t L i s t   o r d e r   b y   i d  
         e n d  
  
 C l e a n U p :  
         r e t u r n  
  
 E _ O A E r r o r :  
         e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
         g o t o   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ c h e c k i n o b j e c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ c h e c k i n o b j e c t ]  
         @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
         @ v c h O b j e c t N a m e   v a r c h a r ( 2 5 5 ) ,  
         @ v c h C o m m e n t         v a r c h a r ( 2 5 5 ) = ' ' ,  
         @ v c h L o g i n N a m e     v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       v a r c h a r ( 2 5 5 ) = ' ' ,  
         @ i V C S F l a g s           i n t   =   0 ,  
         @ i A c t i o n F l a g       i n t   =   0 ,       / *   0   = >   A d d F i l e ,   1   = >   C h e c k I n   * /  
         @ t x S t r e a m 1           T e x t   =   ' ' ,   / *   d r o p   s t r e a m       * /   / *   T h e r e   i s   a   b u g   t h a t   i f   i t e m s   a r e   N U L L   t h e y   d o   n o t   p a s s   t o   O L E   s e r v e r s   * /  
         @ t x S t r e a m 2           T e x t   =   ' ' ,   / *   c r e a t e   s t r e a m   * /  
         @ t x S t r e a m 3           T e x t   =   ' '     / *   g r a n t   s t r e a m     * /  
  
  
 a s  
  
 	 s e t   n o c o u n t   o n  
  
 	 d e c l a r e   @ i R e t u r n   i n t  
 	 d e c l a r e   @ i O b j e c t I d   i n t  
 	 s e l e c t   @ i O b j e c t I d   =   0  
 	 d e c l a r e   @ i S t r e a m O b j e c t I d   i n t  
  
 	 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 	 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
 	 d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
 	 s e l e c t   @ i P r o p e r t y O b j e c t I d     =   0  
  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         d e c l a r e   @ v c h P r o j e c t N a m e       v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S e r v e r N a m e         v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h D a t a b a s e N a m e     v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ i R e t u r n V a l u e 	     i n t  
         d e c l a r e   @ p o s 	 	 	     i n t  
         d e c l a r e   @ v c h P r o c L i n e P i e c e   v a r c h a r ( 2 5 5 )  
  
          
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t ' ,               @ v c h P r o j e c t N a m e       O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I ' ,   @ v c h S o u r c e S a f e I N I   O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L S e r v e r ' ,           @ v c h S e r v e r N a m e         O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L D a t a b a s e ' ,       @ v c h D a t a b a s e N a m e     O U T  
  
         i f   @ c h O b j e c t T y p e   =   ' P R O C '  
         b e g i n  
                 i f   @ i A c t i o n F l a g   =   1  
                 b e g i n  
                         / *   P r o c e d u r e   C a n   h a v e   u p   t o   t h r e e   s t r e a m s  
                         D r o p   S t r e a m ,   C r e a t e   S t r e a m ,   G R A N T   s t r e a m   * /  
  
                         b e g i n   t r a n   c o m p i l e _ a l l  
  
                         / *   t r y   t o   c o m p i l e   t h e   s t r e a m s   * /  
                         e x e c   ( @ t x S t r e a m 1 )  
                         i f   @ @ e r r o r   < >   0   G O T O   E _ C o m p i l e _ F a i l  
  
                         e x e c   ( @ t x S t r e a m 2 )  
                         i f   @ @ e r r o r   < >   0   G O T O   E _ C o m p i l e _ F a i l  
  
                         e x e c   ( @ t x S t r e a m 3 )  
                         i f   @ @ e r r o r   < >   0   G O T O   E _ C o m p i l e _ F a i l  
                 e n d  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A G e t P r o p e r t y   @ i O b j e c t I d ,   ' G e t S t r e a m O b j e c t ' ,   @ i S t r e a m O b j e c t I d   O U T  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
                  
                 i f   @ i A c t i o n F l a g   =   1  
                 b e g i n  
                          
                         d e c l a r e   @ i S t r e a m L e n g t h   i n t  
 	 	 	  
 	 	 	 s e l e c t   @ p o s = 1  
 	 	 	 s e l e c t   @ i S t r e a m L e n g t h   =   d a t a l e n g t h ( @ t x S t r e a m 2 )  
 	 	 	  
 	 	 	 i f   @ i S t r e a m L e n g t h   >   0  
 	 	 	 b e g i n  
 	 	 	  
 	 	 	 	 w h i l e   @ p o s   <   @ i S t r e a m L e n g t h  
 	 	 	 	 b e g i n  
 	 	 	 	 	 	  
 	 	 	 	 	 s e l e c t   @ v c h P r o c L i n e P i e c e   =   s u b s t r i n g ( @ t x S t r e a m 2 ,   @ p o s ,   2 5 5 )  
 	 	 	 	 	  
 	 	 	 	 	 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i S t r e a m O b j e c t I d ,   ' A d d S t r e a m ' ,   @ i R e t u r n V a l u e   O U T ,   @ v c h P r o c L i n e P i e c e  
                         	 	 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
                         	 	  
 	 	 	 	 	 s e l e c t   @ p o s   =   @ p o s   +   2 5 5  
 	 	 	 	 	  
 	 	 	 	 e n d  
                          
 	 	 	 	 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 ' C h e c k I n _ S t o r e d P r o c e d u r e ' ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s P r o j e c t N a m e   =   @ v c h P r o j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S o u r c e S a f e I N I   =   @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S e r v e r N a m e   =   @ v c h S e r v e r N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s D a t a b a s e N a m e   =   @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s O b j e c t N a m e   =   @ v c h O b j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s C o m m e n t   =   @ v c h C o m m e n t ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s L o g i n N a m e   =   @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s P a s s w o r d   =   @ v c h P a s s w o r d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ i V C S F l a g s   =   @ i V C S F l a g s ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ i A c t i o n F l a g   =   @ i A c t i o n F l a g ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S t r e a m   =   ' '  
                                                                                  
 	 	 	 e n d  
                 e n d  
                 e l s e  
                 b e g i n  
                  
                         s e l e c t   c o l i d ,   t e x t   i n t o   # P r o c L i n e s  
                         f r o m   s y s c o m m e n t s  
                         w h e r e   i d   =   o b j e c t _ i d ( @ v c h O b j e c t N a m e )  
                         o r d e r   b y   c o l i d  
  
                         d e c l a r e   @ i C u r P r o c L i n e   i n t  
                         d e c l a r e   @ i P r o c L i n e s   i n t  
                         s e l e c t   @ i C u r P r o c L i n e   =   1  
                         s e l e c t   @ i P r o c L i n e s   =   ( s e l e c t   c o u n t ( * )   f r o m   # P r o c L i n e s )  
                         w h i l e   @ i C u r P r o c L i n e   < =   @ i P r o c L i n e s  
                         b e g i n  
                                 s e l e c t   @ p o s   =   1  
                                 d e c l a r e   @ i C u r L i n e S i z e   i n t  
                                 s e l e c t   @ i C u r L i n e S i z e   =   l e n ( ( s e l e c t   t e x t   f r o m   # P r o c L i n e s   w h e r e   c o l i d   =   @ i C u r P r o c L i n e ) )  
                                 w h i l e   @ p o s   < =   @ i C u r L i n e S i z e  
                                 b e g i n                                  
                                         s e l e c t   @ v c h P r o c L i n e P i e c e   =   c o n v e r t ( v a r c h a r ( 2 5 5 ) ,  
                                                 s u b s t r i n g ( ( s e l e c t   t e x t   f r o m   # P r o c L i n e s   w h e r e   c o l i d   =   @ i C u r P r o c L i n e ) ,  
                                                                     @ p o s ,   2 5 5   ) )  
                                         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i S t r e a m O b j e c t I d ,   ' A d d S t r e a m ' ,   @ i R e t u r n V a l u e   O U T ,   @ v c h P r o c L i n e P i e c e  
                                         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
                                         s e l e c t   @ p o s   =   @ p o s   +   2 5 5                                      
                                 e n d  
                                 s e l e c t   @ i C u r P r o c L i n e   =   @ i C u r P r o c L i n e   +   1  
                         e n d  
                         d r o p   t a b l e   # P r o c L i n e s  
  
                         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 ' C h e c k I n _ S t o r e d P r o c e d u r e ' ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s P r o j e c t N a m e   =   @ v c h P r o j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S o u r c e S a f e I N I   =   @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S e r v e r N a m e   =   @ v c h S e r v e r N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s D a t a b a s e N a m e   =   @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s O b j e c t N a m e   =   @ v c h O b j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s C o m m e n t   =   @ v c h C o m m e n t ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s L o g i n N a m e   =   @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s P a s s w o r d   =   @ v c h P a s s w o r d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ i V C S F l a g s   =   @ i V C S F l a g s ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ i A c t i o n F l a g   =   @ i A c t i o n F l a g ,  
 	 	 	 	 	 	 	 	 	 	 	 	 	 @ s S t r e a m   =   ' '  
                 e n d  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 i f   @ i A c t i o n F l a g   =   1  
                 b e g i n  
                         c o m m i t   t r a n   c o m p i l e _ a l l  
                         i f   @ @ e r r o r   < >   0   G O T O   E _ C o m p i l e _ F a i l  
                 e n d  
  
         e n d  
  
 C l e a n U p :  
 	 r e t u r n  
  
 E _ C o m p i l e _ F a i l :  
 	 d e c l a r e   @ l e r r o r   i n t  
 	 s e l e c t   @ l e r r o r   =   @ @ e r r o r  
 	 r o l l b a c k   t r a n   c o m p i l e _ a l l  
 	 R A I S E R R O R   ( @ l e r r o r , 1 6 , - 1 )  
 	 g o t o   C l e a n U p  
  
 E _ O A E r r o r :  
 	 i f   @ i A c t i o n F l a g   =   1   r o l l b a c k   t r a n   c o m p i l e _ a l l  
 	 e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
 	 g o t o   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ c h e c k o u t o b j e c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ c h e c k o u t o b j e c t ]  
         @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
         @ v c h O b j e c t N a m e   v a r c h a r ( 2 5 5 ) ,  
         @ v c h C o m m e n t         v a r c h a r ( 2 5 5 ) ,  
         @ v c h L o g i n N a m e     v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       v a r c h a r ( 2 5 5 ) ,  
         @ i V C S F l a g s           i n t   =   0 ,  
         @ i A c t i o n F l a g       i n t   =   0 / *   0   = >   C h e c k o u t ,   1   = >   G e t L a t e s t ,   2   = >   U n d o C h e c k O u t   * /  
  
 a s  
  
 	 s e t   n o c o u n t   o n  
  
 	 d e c l a r e   @ i R e t u r n   i n t  
 	 d e c l a r e   @ i O b j e c t I d   i n t  
 	 s e l e c t   @ i O b j e c t I d   = 0  
  
 	 d e c l a r e   @ V S S G U I D   v a r c h a r ( 1 0 0 )  
 	 s e l e c t   @ V S S G U I D   =   ' S Q L V e r s i o n C o n t r o l . V C S _ S Q L '  
  
 	 d e c l a r e   @ i R e t u r n V a l u e   i n t  
 	 s e l e c t   @ i R e t u r n V a l u e   =   0  
  
 	 d e c l a r e   @ v c h T e m p T e x t   v a r c h a r ( 2 5 5 )  
  
 	 / *   t h i s   i s   f o r   o u r   s t r i n g s   * /  
 	 d e c l a r e   @ i S t r e a m O b j e c t I d   i n t  
 	 s e l e c t   @ i S t r e a m O b j e c t I d   =   0  
  
         d e c l a r e   @ i P r o p e r t y O b j e c t I d   i n t  
         s e l e c t   @ i P r o p e r t y O b j e c t I d   =   ( s e l e c t   o b j e c t i d   f r o m   d b o . d t p r o p e r t i e s   w h e r e   p r o p e r t y   =   ' V C S P r o j e c t I D ' )  
  
         d e c l a r e   @ v c h P r o j e c t N a m e       v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S o u r c e S a f e I N I   v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h S e r v e r N a m e         v a r c h a r ( 2 5 5 )  
         d e c l a r e   @ v c h D a t a b a s e N a m e     v a r c h a r ( 2 5 5 )  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S P r o j e c t ' ,               @ v c h P r o j e c t N a m e       O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S o u r c e S a f e I N I ' ,   @ v c h S o u r c e S a f e I N I   O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L S e r v e r ' ,           @ v c h S e r v e r N a m e         O U T  
         e x e c   d b o . d t _ g e t p r o p e r t i e s b y i d _ v c s   @ i P r o p e r t y O b j e c t I d ,   ' V C S S Q L D a t a b a s e ' ,       @ v c h D a t a b a s e N a m e     O U T  
  
         i f   @ c h O b j e c t T y p e   =   ' P R O C '  
         b e g i n  
                 / *   P r o c e d u r e   C a n   h a v e   u p   t o   t h r e e   s t r e a m s  
                       D r o p   S t r e a m ,   C r e a t e   S t r e a m ,   G R A N T   s t r e a m   * /  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A C r e a t e   @ V S S G U I D ,   @ i O b j e c t I d   O U T  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i O b j e c t I d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 ' C h e c k O u t _ S t o r e d P r o c e d u r e ' ,  
 	 	 	 	 	 	 	 	 	 	 	 	 N U L L ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s P r o j e c t N a m e   =   @ v c h P r o j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s S o u r c e S a f e I N I   =   @ v c h S o u r c e S a f e I N I ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s O b j e c t N a m e   =   @ v c h O b j e c t N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s S e r v e r N a m e   =   @ v c h S e r v e r N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s D a t a b a s e N a m e   =   @ v c h D a t a b a s e N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s C o m m e n t   =   @ v c h C o m m e n t ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s L o g i n N a m e   =   @ v c h L o g i n N a m e ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ s P a s s w o r d   =   @ v c h P a s s w o r d ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ i V C S F l a g s   =   @ i V C S F l a g s ,  
 	 	 	 	 	 	 	 	 	 	 	 	 @ i A c t i o n F l a g   =   @ i A c t i o n F l a g  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
  
                 e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A G e t P r o p e r t y   @ i O b j e c t I d ,   ' G e t S t r e a m O b j e c t ' ,   @ i S t r e a m O b j e c t I d   O U T  
  
                 i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
  
                 c r e a t e   t a b l e   # c o m m e n t t e x t   ( i d   i n t   i d e n t i t y ,   s o u r c e c o d e   v a r c h a r ( 2 5 5 ) )  
  
  
                 s e l e c t   @ v c h T e m p T e x t   =   ' S T U B '  
                 w h i l e   @ v c h T e m p T e x t   i s   n o t   n u l l  
                 b e g i n  
                         e x e c   @ i R e t u r n   =   m a s t e r . d b o . s p _ O A M e t h o d   @ i S t r e a m O b j e c t I d ,   ' G e t S t r e a m ' ,   @ i R e t u r n V a l u e   O U T ,   @ v c h T e m p T e x t   O U T  
                         i f   @ i R e t u r n   < >   0   G O T O   E _ O A E r r o r  
                          
                         i f   ( @ v c h T e m p T e x t   =   ' ' )   s e t   @ v c h T e m p T e x t   =   n u l l  
                         i f   ( @ v c h T e m p T e x t   i s   n o t   n u l l )   i n s e r t   i n t o   # c o m m e n t t e x t   ( s o u r c e c o d e )   s e l e c t   @ v c h T e m p T e x t  
                 e n d  
  
                 s e l e c t   ' V C S ' = s o u r c e c o d e   f r o m   # c o m m e n t t e x t   o r d e r   b y   i d  
                 s e l e c t   ' S Q L ' = t e x t   f r o m   s y s c o m m e n t s   w h e r e   i d   =   o b j e c t _ i d ( @ v c h O b j e c t N a m e )   o r d e r   b y   c o l i d  
  
         e n d  
  
 C l e a n U p :  
         r e t u r n  
  
 E _ O A E r r o r :  
         e x e c   d b o . d t _ d i s p l a y o a e r r o r   @ i O b j e c t I d ,   @ i R e t u r n  
         G O T O   C l e a n U p  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ d i s p l a y o a e r r o r _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 C R E A T E   P R O C E D U R E   [ d b o ] . [ d t _ d i s p l a y o a e r r o r _ u ]  
         @ i O b j e c t   i n t ,  
         @ i r e s u l t   i n t  
 a s  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ d i s p l a y o a e r r o r   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ d i s p l a y o a e r r o r   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ d i s p l a y o a e r r o r  
 	 	 @ i O b j e c t ,  
 	 	 @ i r e s u l t  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ a d d t o s o u r c e c o n t r o l _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ a d d t o s o u r c e c o n t r o l _ u ]  
         @ v c h S o u r c e S a f e I N I   n v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ v c h P r o j e c t N a m e       n v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h C o m m e n t               n v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h L o g i n N a m e           n v a r c h a r ( 2 5 5 )   = ' ' ,  
         @ v c h P a s s w o r d             n v a r c h a r ( 2 5 5 )   = ' '  
  
 a s  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ a d d t o s o u r c e c o n t r o l   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ a d d t o s o u r c e c o n t r o l   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ a d d t o s o u r c e c o n t r o l    
 	 	 @ v c h S o u r c e S a f e I N I ,    
 	 	 @ v c h P r o j e c t N a m e ,    
 	 	 @ v c h C o m m e n t ,    
 	 	 @ v c h L o g i n N a m e ,    
 	 	 @ v c h P a s s w o r d  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ c h e c k i n o b j e c t _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ c h e c k i n o b j e c t _ u ]  
         @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
         @ v c h O b j e c t N a m e   n v a r c h a r ( 2 5 5 ) ,  
         @ v c h C o m m e n t         n v a r c h a r ( 2 5 5 ) = ' ' ,  
         @ v c h L o g i n N a m e     n v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       n v a r c h a r ( 2 5 5 ) = ' ' ,  
         @ i V C S F l a g s           i n t   =   0 ,  
         @ i A c t i o n F l a g       i n t   =   0 ,       / *   0   = >   A d d F i l e ,   1   = >   C h e c k I n   * /  
         @ t x S t r e a m 1           t e x t   =   ' ' ,     / *   d r o p   s t r e a m       * /   / *   T h e r e   i s   a   b u g   t h a t   i f   i t e m s   a r e   N U L L   t h e y   d o   n o t   p a s s   t o   O L E   s e r v e r s   * /  
         @ t x S t r e a m 2           t e x t   =   ' ' ,     / *   c r e a t e   s t r e a m   * /  
         @ t x S t r e a m 3           t e x t   =   ' '       / *   g r a n t   s t r e a m     * /  
  
 a s 	  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ c h e c k i n o b j e c t   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ c h e c k i n o b j e c t   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ c h e c k i n o b j e c t  
 	 	 @ c h O b j e c t T y p e ,  
 	 	 @ v c h O b j e c t N a m e ,  
 	 	 @ v c h C o m m e n t ,  
 	 	 @ v c h L o g i n N a m e ,  
 	 	 @ v c h P a s s w o r d ,  
 	 	 @ i V C S F l a g s ,  
 	 	 @ i A c t i o n F l a g ,        
 	 	 @ t x S t r e a m 1 , 	 	  
 	 	 @ t x S t r e a m 2 , 	 	  
 	 	 @ t x S t r e a m 3  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ c h e c k o u t o b j e c t _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ c h e c k o u t o b j e c t _ u ]  
         @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
         @ v c h O b j e c t N a m e   n v a r c h a r ( 2 5 5 ) ,  
         @ v c h C o m m e n t         n v a r c h a r ( 2 5 5 ) ,  
         @ v c h L o g i n N a m e     n v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       n v a r c h a r ( 2 5 5 ) ,  
         @ i V C S F l a g s           i n t   =   0 ,  
         @ i A c t i o n F l a g       i n t   =   0 / *   0   = >   C h e c k o u t ,   1   = >   G e t L a t e s t ,   2   = >   U n d o C h e c k O u t   * /  
  
 a s  
  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ c h e c k o u t o b j e c t   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ c h e c k o u t o b j e c t   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ c h e c k o u t o b j e c t  
 	 	 @ c h O b j e c t T y p e ,      
 	 	 @ v c h O b j e c t N a m e ,    
 	 	 @ v c h C o m m e n t ,          
 	 	 @ v c h L o g i n N a m e ,      
 	 	 @ v c h P a s s w o r d ,      
 	 	 @ i V C S F l a g s ,          
 	 	 @ i A c t i o n F l a g  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ i s u n d e r s o u r c e c o n t r o l _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ i s u n d e r s o u r c e c o n t r o l _ u ]  
         @ v c h L o g i n N a m e   n v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ v c h P a s s w o r d     n v a r c h a r ( 2 5 5 )   =   ' ' ,  
         @ i W h o T o o             i n t   =   0   / *   0   = >   J u s t   c h e c k   p r o j e c t ;   1   = >   g e t   l i s t   o f   o b j s   * /  
  
 a s  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ i s u n d e r s o u r c e c o n t r o l   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ i s u n d e r s o u r c e c o n t r o l   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ i s u n d e r s o u r c e c o n t r o l  
 	 	 @ v c h L o g i n N a m e ,  
 	 	 @ v c h P a s s w o r d ,  
 	 	 @ i W h o T o o  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ v a l i d a t e l o g i n p a r a m s _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ v a l i d a t e l o g i n p a r a m s _ u ]  
         @ v c h L o g i n N a m e     n v a r c h a r ( 2 5 5 ) ,  
         @ v c h P a s s w o r d       n v a r c h a r ( 2 5 5 )  
 a s  
  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ v a l i d a t e l o g i n p a r a m s   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ v a l i d a t e l o g i n p a r a m s   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ v a l i d a t e l o g i n p a r a m s  
 	 	 @ v c h L o g i n N a m e ,  
 	 	 @ v c h P a s s w o r d  
 G O  
 / * * * * * *   O b j e c t :     S t o r e d P r o c e d u r e   [ d b o ] . [ d t _ w h o c h e c k e d o u t _ u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O F F  
 G O  
 c r e a t e   p r o c   [ d b o ] . [ d t _ w h o c h e c k e d o u t _ u ]  
                 @ c h O b j e c t T y p e     c h a r ( 4 ) ,  
                 @ v c h O b j e c t N a m e   n v a r c h a r ( 2 5 5 ) ,  
                 @ v c h L o g i n N a m e     n v a r c h a r ( 2 5 5 ) ,  
                 @ v c h P a s s w o r d       n v a r c h a r ( 2 5 5 )  
  
 a s  
  
 	 - -   T h i s   p r o c e d u r e   s h o u l d   n o   l o n g e r   b e   c a l l e d ;     d t _ w h o c h e c k e d o u t   s h o u l d   b e   c a l l e d   i n s t e a d .  
 	 - -   C a l l s   a r e   f o r w a r d e d   t o   d t _ w h o c h e c k e d o u t   t o   m a i n t a i n   b a c k w a r d   c o m p a t i b i l i t y .  
 	 s e t   n o c o u n t   o n  
 	 e x e c   d b o . d t _ w h o c h e c k e d o u t  
 	 	 @ c h O b j e c t T y p e ,    
 	 	 @ v c h O b j e c t N a m e ,  
 	 	 @ v c h L o g i n N a m e ,    
 	 	 @ v c h P a s s w o r d  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ I n s t r u c t i o n a l D e p a r t m e n t _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 0   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ I n s t r u c t i o n a l D e p a r t m e n t ]   A D D     C O N S T R A I N T   [ D F _ I n s t r u c t i o n a l D e p a r t m e n t _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ I n s t r u c t i o n a l D e p a r t m e n t _ D e p a r t m e n t N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 0   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ I n s t r u c t i o n a l D e p a r t m e n t ]   A D D     C O N S T R A I N T   [ D F _ I n s t r u c t i o n a l D e p a r t m e n t _ D e p a r t m e n t N a m e ]     D E F A U L T   ( ' ' )   F O R   [ D e p a r t m e n t N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ C A A N ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ C A A N ]     D E F A U L T   ( ' ' )   F O R   [ C A A N ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g N a m e ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g C o m m o n N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g C o m m o n N a m e ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g C o m m o n N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g A d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ B u i l d i n g A d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g A d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g S o u r c e _ O w n e r s h i p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g S o u r c e ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g S o u r c e _ O w n e r s h i p ]     D E F A U L T   ( ' 1 ' )   F O R   [ O w n e r s h i p ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 1 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ p l a n _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ p l a n _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ p l a n _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ s t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ s t a t u s ]     D E F A U L T   ( ' N ' )   F O R   [ s t a t u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ a c a d _ s t a f _ _ 4 3 6 B F E E 3 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ a c a d _ s t a f _ _ 4 3 6 B F E E 3 ]     D E F A U L T   ( ( 0 ) )   F O R   [ a c a d _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ f u l l t i m e _ _ _ 4 4 6 0 2 3 1 C ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ f u l l t i m e _ _ _ 4 4 6 0 2 3 1 C ]     D E F A U L T   ( ( 0 ) )   F O R   [ f u l l t i m e _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ p a r t t i m e _ _ _ 4 5 5 4 4 7 5 5 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ p a r t t i m e _ _ _ 4 5 5 4 4 7 5 5 ]     D E F A U L T   ( ( 0 ) )   F O R   [ p a r t t i m e _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ s t u d e n t _ s _ _ 4 6 4 8 6 B 8 E ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ s t u d e n t _ s _ _ 4 6 4 8 6 B 8 E ]     D E F A U L T   ( ( 0 ) )   F O R   [ s t u d e n t _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ o t h e r _ s t a _ _ 4 7 3 C 8 F C 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ o t h e r _ s t a _ _ 4 7 3 C 8 F C 7 ]     D E F A U L T   ( ( 0 ) )   F O R   [ o t h e r _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ r e s _ f e l l o w s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ r e s _ f e l l o w s ]     D E F A U L T   ( ( 0 ) )   F O R   [ r e s _ f e l l o w s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ v o l u n t e e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ v o l u n t e e r s ]     D E F A U L T   ( ( 0 ) )   F O R   [ v o l u n t e e r s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ g u e s t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ g u e s t s ]     D E F A U L T   ( ( 0 ) )   F O R   [ g u e s t s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ p l a n s _ _ e m p l o y _ f a _ _ 6 4 0 D D 8 9 F ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ _ p l a n s _ _ e m p l o y _ f a _ _ 6 4 0 D D 8 9 F ]     D E F A U L T   ( ' ' )   F O R   [ e m p l o y _ f a c u l t y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ w o r k s t a t i o n _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ w o r k s t a t i o n _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ w o r k s t a t i o n _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ w o r k s t a t i o n _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ w o r k s t a t i o n _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ w o r k s t a t i o n _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ l a p t o p _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ l a p t o p _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ l a p t o p _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ l a p t o p _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ l a p t o p _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ l a p t o p _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ t e l e p h o n e _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ t e l e p h o n e _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ t e l e p h o n e _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ t e l e p h o n e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ t e l e p h o n e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ t e l e p h o n e _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ p r i n t e r _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ p r i n t e r _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ p r i n t e r _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ p r i n t e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ p r i n t e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ p r i n t e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ f a x _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ f a x _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ f a x _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ f a x _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ f a x _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ f a x _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ c o p i e r _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ c o p i e r _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ c o p i e r _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ c o p i e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ c o p i e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ c o p i e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s c a n n e r _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s c a n n e r _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ s c a n n e r _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s c a n n e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s c a n n e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ s c a n n e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s e r v e r _ m i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s e r v e r _ m i n ]     D E F A U L T   ( ( 0 ) )   F O R   [ k e y _ s e r v e r _ m i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s e r v e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s e r v e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ s e r v e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ o t h e r _ e q u i p m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ o t h e r _ e q u i p m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ o t h e r _ e q u i p m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ f a c i l i t i e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ f a c i l i t i e s ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ f a c i l i t i e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ o t h e r _ r e s o u r c e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ o t h e r _ r e s o u r c e s ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ o t h e r _ r e s o u r c e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s u p p l y _ c r i s i s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s u p p l y _ c r i s i s ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ s u p p l y _ c r i s i s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ e m e r g e n c y _ c o n t a c t _ c o p y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ h o l d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ h o l d ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ w h o _ h o l d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ u p d a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ u p d a t e ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ w h o _ u p d a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ c h e c k _ m s g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ c h e c k _ m s g ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ w h o _ c h e c k _ m s g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ w h o _ r e c o r d _ g r e e t i n g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ p o s t _ m s g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ w h o _ p o s t _ m s g ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ w h o _ p o s t _ m s g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ s h a r e d _ p a s s w o r d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ s h a r e d _ p a s s w o r d ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ s h a r e d _ p a s s w o r d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ b a s i c _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ b a s i c _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ b a s i c _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ t r a n s p o r t a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ t r a n s p o r t a t i o n ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ t r a n s p o r t a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ f i l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ f i l e ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ f i l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ f i l e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ f i l e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ f i l e _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ u c b ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ u c b ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ u c b ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ u c b _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ u c b _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ u c b _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ l o c a l _ a u t o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ l o c a l _ a u t o ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ l o c a l _ a u t o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ l o c a l _ a u t o _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ l o c a l _ a u t o _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ l o c a l _ a u t o _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ l o c a l _ m a n u ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ l o c a l _ m a n u ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ l o c a l _ m a n u ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ l o c a l _ m a n u _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ l o c a l _ m a n u _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ l o c a l _ m a n u _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ o t h e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ o t h e r ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ o t h e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ o t h e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ o t h e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ o t h e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ n o _ b a c k u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ n o _ b a c k u p ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ n o _ b a c k u p ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ n o _ b a c k u p _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ n o _ b a c k u p _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ n o _ b a c k u p _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ n o t _ k n o w ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ n o t _ k n o w ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ n o t _ k n o w ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ n o t _ k n o w _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ n o t _ k n o w _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ n o t _ k n o w _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ e m p _ f l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ e m p _ f l a g ]     D E F A U L T   ( ' N ' )   F O R   [ i t _ w s _ s u p p o r t _ d e p t _ f l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ d e p t _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ d e p t _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ s u p p o r t _ d e p t _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ c a m p u s _ f l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ c a m p u s _ f l a g ]     D E F A U L T   ( ' N ' )   F O R   [ i t _ w s _ s u p p o r t _ c a m p u s _ f l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ c a m p u s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ c a m p u s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ s u p p o r t _ c a m p u s _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ v e n d o r _ f l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ v e n d o r _ f l a g ]     D E F A U L T   ( ' N ' )   F O R   [ i t _ w s _ s u p p o r t _ v e n d o r _ f l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ v e n d o r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ v e n d o r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ s u p p o r t _ v e n d o r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ o t h e r _ f l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ o t h e r _ f l a g ]     D E F A U L T   ( ' N ' )   F O R   [ i t _ w s _ s u p p o r t _ o t h e r _ f l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ o t h e r _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ w s _ s u p p o r t _ o t h e r _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ w s _ s u p p o r t _ o t h e r _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ w h e r e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ w h e r e ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ w h e r e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ w h e n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ w h e n ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ w h e n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ r e q u i r e m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ r e q u i r e m e n t ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ r e q u i r e m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ s t a f f ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ s t a f f ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ o t h e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ o t h e r ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ o t h e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ c r e a t e _ d a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ c r e a t e _ d a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ c r e a t e _ d a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ l a s t _ m o d i f i e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ l a s t _ m o d i f i e d ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ l a s t _ m o d i f i e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ a p p r o v a l _ f l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ a p p r o v a l _ f l a g ]     D E F A U L T   ( ' 0 ' )   F O R   [ a p p r o v a l _ f l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ a p p r o v e d _ b y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ a p p r o v e d _ b y ]     D E F A U L T   ( ' ' )   F O R   [ a p p r o v e d _ b y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ a p p r o v e r _ t y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ a p p r o v e r _ t y p e ]     D E F A U L T   ( ' 1 ' )   F O R   [ a p p r o v e r _ t y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ w o r k _ h o m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ w o r k _ h o m e ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ w o r k _ h o m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ k e y _ s u p p l i e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ k e y _ s u p p l i e s ]     D E F A U L T   ( ' ' )   F O R   [ k e y _ s u p p l i e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i t _ h o w t o _ c a n n o t _ w o r k _ a r o u n d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i t _ h o w t o _ c a n n o t _ w o r k _ a r o u n d ]     D E F A U L T   ( ' ' )   F O R   [ i t _ h o w t o _ c a n n o t _ w o r k _ a r o u n d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ c o s t _ c e n t e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ c o s t _ c e n t e r ]     D E F A U L T   ( ' ' )   F O R   [ c o s t _ c e n t e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ e v a c u a t i o n _ p l a n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ e v a c u a t i o n _ p l a n ]     D E F A U L T   ( ' 0 ' )   F O R   [ e v a c u a t i o n _ p l a n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ A c r o n y m I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ A c r o n y m I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ A c r o n y m I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ M a j o r D i v i s i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ M a j o r D i v i s i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ M a j o r D i v i s i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ H e a d O f U n i t N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ H e a d O f U n i t N a m e ]     D E F A U L T   ( ' ' )   F O R   [ H e a d O f U n i t N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ h e a d o f U n i t T i t l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ h e a d o f U n i t T i t l e ]     D E F A U L T   ( ' ' )   F O R   [ H e a d O f U n i t T i t l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ n o t _ a p p l i c a b l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ n o t _ a p p l i c a b l e ]     D E F A U L T   ( ( 0 ) )   F O R   [ n o t _ a p p l i c a b l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ n a _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ n a _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ n a _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ o l d _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ o l d _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ O b j e c t T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ O b j e c t T y p e ]     D E F A U L T   ( ' ' )   F O R   [ O b j e c t T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ E v e n t T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ E v e n t T y p e ]     D E F A U L T   ( ' ' )   F O R   [ E v e n t T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ O b j e c t I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ O b j e c t I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ O b j e c t I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ U s e r I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ U s e r I D ]     D E F A U L T   ( ' ' )   F O R   [ U s e r I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ H o s t I P ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ H o s t I P ]     D E F A U L T   ( ' ' )   F O R   [ H o s t I P ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ M o d u l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ M o d u l e ]     D E F A U L T   ( ' ' )   F O R   [ M o d u l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ E v e n t D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ E v e n t D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ E v e n t D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m L o g _ C o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m L o g _ C o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ C o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ I n s t i t u t i o n I D _ u n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m L o g ]   A D D     C O N S T R A I N T   [ I n s t i t u t i o n I D _ u n ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ T a b l e _ 1 _ L o o k u p N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e s c r i p t i o n L o o k u p ]   A D D     C O N S T R A I N T   [ D F _ T a b l e _ 1 _ L o o k u p N a m e ]     D E F A U L T   ( ' ' )   F O R   [ L o o k u p N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ T a b l e _ 1 _ V a l u e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e s c r i p t i o n L o o k u p ]   A D D     C O N S T R A I N T   [ D F _ T a b l e _ 1 _ V a l u e ]     D E F A U L T   ( ' ' )   F O R   [ L o o k u p V a l u e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e s c r i p t i o n L o o k u p _ D e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e s c r i p t i o n L o o k u p ]   A D D     C O N S T R A I N T   [ D F _ D e s c r i p t i o n L o o k u p _ D e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ L o o k u p D e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ U C N e t I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ U C N e t I D ]     D E F A U L T   ( ' ' )   F O R   [ A u t h I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ S e c u r i t y T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ S e c u r i t y T y p e ]     D E F A U L T   ( ' 9 ' )   F O R   [ S e c u r i t y T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ F i r s t N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ F i r s t N a m e ]     D E F A U L T   ( ' ' )   F O R   [ F i r s t N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ L a s t N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ L a s t N a m e ]     D E F A U L T   ( ' ' )   F O R   [ L a s t N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ P h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ P h o n e ]     D E F A U L T   ( ' ' )   F O R   [ W o r k P h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ H o m e P h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ H o m e P h o n e ]     D E F A U L T   ( ' ' )   F O R   [ H o m e P h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ C e l l P h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ C e l l P h o n e ]     D E F A U L T   ( ' ' )   F O R   [ C e l l P h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ E M a i l R e g u l a r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ E M a i l R e g u l a r ]     D E F A U L T   ( ' ' )   F O R   [ E M a i l R e g u l a r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ E M a i l B a c k u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ E M a i l B a c k u p ]     D E F A U L T   ( ' ' )   F O R   [ E M a i l B a c k u p ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ W o r k F A X ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ W o r k F A X ]     D E F A U L T   ( ' ' )   F O R   [ W o r k F A X ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ T i t l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ T i t l e ]     D E F A U L T   ( ' ' )   F O R   [ T i t l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t ]     D E F A U L T   ( ' ' )   F O R   [ D e p a r t m e n t N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t I D ]     D E F A U L T   ( ' ' )   F O R   [ D e p a r t m e n t O r g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t O r g H i e r a r c h y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ D e p a r t m e n t O r g H i e r a r c h y ]     D E F A U L T   ( ' ' )   F O R   [ D e p a r t m e n t O r g H i e r a r c h y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ W o r k A d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ W o r k A d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ W o r k A d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ H o m e A d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ H o m e A d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ H o m e A d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ A c c e s s S t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ A c c e s s S t a t u s ]     D E F A U L T   ( ' 1 ' )   F O R   [ A c c e s s S t a t u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ L o c k S t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ L o c k S t a t u s ]     D E F A U L T   ( ' 0 ' )   F O R   [ L o c k S t a t u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ C r e a t e d D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ C r e a t e d D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ C r e a t e d D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ A f f i l i a t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ A f f i l i a t i o n s ]     D E F A U L T   ( ' ' )   F O R   [ A f f i l i a t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ P a s s w o r d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ P a s s w o r d ]     D E F A U L T   ( ' ' )   F O R   [ P a s s w o r d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U s e r S e c u r i t y _ S e c u r i t y A t t r i b u t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     C O N S T R A I N T   [ D F _ U s e r S e c u r i t y _ S e c u r i t y A t t r i b u t e ]     D E F A U L T   ( ( 0 ) )   F O R   [ S e c u r i t y A t t r i b u t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ U s e r S e c u r _ _ D i r e c _ _ 7 8 9 5 8 A E 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U s e r S e c u r i t y ]   A D D     D E F A U L T   ( ' ' )   F O R   [ D i r e c t o r y I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ S y s t e m N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ S y s t e m N a m e ]     D E F A U L T   ( ' ' )   F O R   [ S y s t e m N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ D e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ D e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ D e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ P h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ P h o n e ]     D E F A U L T   ( ' ' )   F O R   [ P h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ F a x ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ F a x ]     D E F A U L T   ( ' ' )   F O R   [ F a x ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ E M a i l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ E M a i l ]     D E F A U L T   ( ' ' )   F O R   [ E M a i l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ S y s t e m S t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ S y s t e m S t a t u s ]     D E F A U L T   ( ( 1 ) )   F O R   [ S y s t e m S t a t u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ V e r s i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 1   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ V e r s i o n ]     D E F A U L T   ( ' 3 . 0 ' )   F O R   [ V e r s i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m S e t u p _ R e l e a s e D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m S e t u p ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m S e t u p _ R e l e a s e D a t e ]     D E F A U L T   ( ( ( 1 ) / ( 1 ) ) / ( 2 0 0 9 ) )   F O R   [ R e l e a s e D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ u t i l i t y _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ k e y _ u t i l i t y _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ u t i l i t y _ U t i l i t y I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ k e y _ u t i l i t y _ U t i l i t y I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ U t i l i t y I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ u t i l i t y _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ k e y _ u t i l i t y _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m _ m e m b e r s _ k t _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m _ m e m b e r s _ k t _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ k t _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m _ m e m b e r s _ U s e r I d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m _ m e m b e r s _ U s e r I d ]     D E F A U L T   ( ( 0 ) )   F O R   [ U s e r I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m _ m e m b e r s _ f i r s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m _ m e m b e r s _ f i r s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ f i r s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m _ m e m b e r s _ l a s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m _ m e m b e r s _ l a s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ l a s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m _ m e m b e r s _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m _ m e m b e r s _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ I n s t r u c t i o n a l D e p a r t m e n t I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ I n s t r u c t i o n a l D e p a r t m e n t I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t r u c t i o n a l D e p a r t m e n t I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ u s a g e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ u s a g e ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ b S p a c e _ u s a g e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ e x p a n d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ e x p a n d ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ b S p a c e _ e x p a n d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ b _ b S p a c e _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ u s a g e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ u s a g e ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ b S p a c e _ g r a d e _ u s a g e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ e x p a n d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ e x p a n d ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ b S p a c e _ g r a d e _ e x p a n d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ b S p a c e _ g r a d e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ b _ b S p a c e _ g r a d e _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ u s a g e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ u s a g e ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ g s i _ c o m m u n i c a t i o n _ u s a g e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ e x p a n d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ e x p a n d ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ g s i _ c o m m u n i c a t i o n _ e x p a n d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ g s i _ c o m m u n i c a t i o n _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ b _ g s i _ c o m m u n i c a t i o n _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ u s a g e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ u s a g e ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ c o m m o n _ m a t e r i a l s _ u s a g e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ e x p a n d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ e x p a n d ]     D E F A U L T   ( ' 0 ' )   F O R   [ b _ c o m m o n _ m a t e r i a l s _ e x p a n d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ b _ c o m m o n _ m a t e r i a l s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ b _ c o m m o n _ m a t e r i a l s _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p r i o r i t i z e _ c o u r s e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p r i o r i t i z e _ c o u r s e ]     D E F A U L T   ( ' 0 ' )   F O R   [ c _ p r i o r i t i z e _ c o u r s e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p r i o r i t i z e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p r i o r i t i z e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c _ p r i o r i t i z e _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ c o m m u n i c a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ c o m m u n i c a t i o n ]     D E F A U L T   ( ' 0 ' )   F O R   [ c _ c o m m u n i c a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ c o m m u n i c a t i o n _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ c o m m u n i c a t i o n _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c _ c o m m u n i c a t i o n _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ b a c k u p _ p e r s o n n e l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ b a c k u p _ p e r s o n n e l ]     D E F A U L T   ( ' 0 ' )   F O R   [ c _ b a c k u p _ p e r s o n n e l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ b a c k u p _ p e r s o n n e l _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ b a c k u p _ p e r s o n n e l _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c _ b a c k u p _ p e r s o n n e l _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ f a c u l t y _ r e c a l l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ f a c u l t y _ r e c a l l ]     D E F A U L T   ( ' 0 ' )   F O R   [ c _ f a c u l t y _ r e c a l l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ f a c u l t y _ r e c a l l _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ f a c u l t y _ r e c a l l _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c _ f a c u l t y _ r e c a l l _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p e d a g o g y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p e d a g o g y ]     D E F A U L T   ( ' 0 ' )   F O R   [ c _ p e d a g o g y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p e d a g o g y _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ p l a n s _ i n s t r u c t i o n s _ c _ p e d a g o g y _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c _ p e d a g o g y _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ i m p a c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ i m p a c t ]     D E F A U L T   ( ' ' )   F O R   [ i m p a c t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ a l t e r n a t i v e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ a l t e r n a t i v e s ]     D E F A U L T   ( ' ' )   F O R   [ a l t e r n a t i v e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ p i s _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ p i s _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i s _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o u r s e _ n u m b e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o u r s e _ n u m b e r ]     D E F A U L T   ( ' ' )   F O R   [ c o u r s e _ n u m b e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o u r s e _ t i t l e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o u r s e _ t i t l e ]     D E F A U L T   ( ' ' )   F O R   [ c o u r s e _ t i t l e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ b s p a c e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ b s p a c e ]     D E F A U L T   ( ( 0 ) )   F O R   [ b s p a c e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ o t h e r _ c a n _ t e a c h ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ o t h e r _ c a n _ t e a c h ]     D E F A U L T   ( ( 0 ) )   F O R   [ o t h e r _ c a n _ t e a c h ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   A D D     C O N S T R A I N T   [ D F _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ c i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ c i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ c i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ D e p e n d e n c y I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ D e p e n d e n c y I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ D e p e n d e n c y I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k s _ i d _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]   A D D     C O N S T R A I N T   [ D F _ k s _ i d _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k s _ i d _ S k i l l I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]   A D D     C O N S T R A I N T   [ D F _ k s _ i d _ S k i l l I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ S k i l l I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k s _ i d _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]   A D D     C O N S T R A I N T   [ D F _ k s _ i d _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ c i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ c i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ c i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ S t a f f C a t e g o r y I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ S t a f f C a t e g o r y I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ S t a f f C a t e g o r y I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ S h i f t I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ S h i f t I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ S h i f t I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ F T E _ n o r m a l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ F T E _ n o r m a l ]     D E F A U L T   ( ( 0 ) )   F O R   [ F T E _ n o r m a l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f i n g _ r e q _ F T E _ c r i s i s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f i n g _ r e q _ F T E _ c r i s i s ]     D E F A U L T   ( ( 0 ) )   F O R   [ F T E _ c r i s i s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ w o r k _ h o m e _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ w o r k _ h o m e _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ w o r k _ h o m e _ _ n a m e _ _ 1 A F 3 F 9 3 5 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ _ w o r k _ h o m e _ _ n a m e _ _ 1 A F 3 F 9 3 5 ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ w o r k _ h o m e _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ w o r k _ h o m e _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ w o r k _ h o m e _ _ d i s a b _ _ 4 9 E 3 F 2 4 8 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ _ w o r k _ h o m e _ _ d i s a b _ _ 4 9 E 3 F 2 4 8 ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ w o r k _ h o m e _ c u r r e n t l y _ d o e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ k e y _ w o r k _ h o m e _ c u r r e n t l y _ d o e s ]     D E F A U L T   ( ' 0 ' )   F O R   [ c u r r e n t l y _ d o e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ w o r k _ h o m e _ o f f i c e _ p c _ m u s t _ o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ k e y _ w o r k _ h o m e _ o f f i c e _ p c _ m u s t _ o n ]     D E F A U L T   ( ' 0 ' )   F O R   [ o f f i c e _ p c _ m u s t _ o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ w o r k _ h o m e _ p o s i t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ k e y _ w o r k _ h o m e _ p o s i t i o n ]     D E F A U L T   ( ' 0 ' )   F O R   [ i n s t i t u t i o n _ p o s i t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ w o r k _ h o m e _ c o n n e c t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ k e y _ w o r k _ h o m e _ c o n n e c t i o n ]     D E F A U L T   ( ' 0 ' )   F O R   [ b r o a d b a n d _ c o n n e c t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ w o r k _ h o m e _ o l d _ w h _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   A D D     C O N S T R A I N T   [ D F _ k e y _ w o r k _ h o m e _ o l d _ w h _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ w h _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ u s e r _ p l a n _ u i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   A D D     C O N S T R A I N T   [ D F _ u s e r _ p l a n _ u i d ]     D E F A U L T   ( ' ' )   F O R   [ u i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ u s e r _ p l a n _ U s e r I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   A D D     C O N S T R A I N T   [ D F _ u s e r _ p l a n _ U s e r I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ U s e r I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ u s e r _ p l a n _ P l a n A c c e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   A D D     C O N S T R A I N T   [ D F _ u s e r _ p l a n _ P l a n A c c e s s ]     D E F A U L T   ( ' 3 ' )   F O R   [ P l a n A c c e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ u s e r _ p l a n _ C r e a t e D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   A D D     C O N S T R A I N T   [ D F _ u s e r _ p l a n _ C r e a t e D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ A d d e d D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ u s e r _ p l a n _ P l a n C r e a t o r F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   A D D     C O N S T R A I N T   [ D F _ u s e r _ p l a n _ P l a n C r e a t o r F l a g ]     D E F A U L T   ( ' 0 ' )   F O R   [ P l a n C r e a t o r F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ o w n e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ o w n e r ]     D E F A U L T   ( ' ' )   F O R   [ o w n e r _ d e p a r t m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ o r i g i n a l _ f i l e _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ o r i g i n a l _ f i l e _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ o r i g i n a l _ f i l e _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ l o c _ p r i n t e d _ c o p i e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ l o c _ p r i n t e d _ c o p i e s ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ k e p t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ m e d i u m I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ m e d i u m I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ m e d i u m I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ c o n t a c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ c o n t a c t ]     D E F A U L T   ( ' ' )   F O R   [ c o n t a c t s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ d o c u m e n t s _ b a c k u p _ m e a s u r e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ d o c u m e n t s _ b a c k u p _ m e a s u r e s ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ m e a s u r e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ p l a n _ d o c u m e n t s _ o l d _ k p d _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ p l a n _ d o c u m e n t s _ o l d _ k p d _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k p d _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ c o n t a c t s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ c o n t a c t s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ c o n t a c t s _ U s e r I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ c o n t a c t s _ U s e r I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ U s e r I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ c o n t a c t s _ C o n t a c t C o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ c o n t a c t s _ C o n t a c t C o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ C o n t a c t C o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ c o n t a c t s _ C o n t a c t T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ c o n t a c t s _ C o n t a c t T y p e ]     D E F A U L T   ( ' 0 ' )   F O R   [ C o n t a c t T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ c o n t a c t s _ A d d e d D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ c o n t a c t s _ A d d e d D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ A d d e d D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ f i r s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ f i r s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ f i r s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ l a s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ l a s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ l a s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ s p e c i a l _ s k i l l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ s p e c i a l _ s k i l l ]     D E F A U L T   ( ' ' )   F O R   [ s p e c i a l _ s k i l l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ t i t l e _ o r _ f u n c t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ t i t l e _ o r _ f u n c t i o n ]     D E F A U L T   ( ' ' )   F O R   [ t i t l e _ o r _ f u n c t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ f i r s t _ s u c c e s s o r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ f i r s t _ s u c c e s s o r ]     D E F A U L T   ( ' 0 ' )   F O R   [ f i r s t _ s u c c e s s o r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ s e c o n d _ s u c c e s s o r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ s e c o n d _ s u c c e s s o r ]     D E F A U L T   ( ' 0 ' )   F O R   [ s e c o n d _ s u c c e s s o r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ t h i r d _ s u c c e s s o r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ t h i r d _ s u c c e s s o r ]     D E F A U L T   ( ' 0 ' )   F O R   [ t h i r d _ s u c c e s s o r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ h o l d s _ f o r m a l _ d e l e g a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ h o l d s _ f o r m a l _ d e l e g a t i o n ]     D E F A U L T   ( ' 0 ' )   F O R   [ h o l d s _ f o r m a l _ d e l e g a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ u n i t _ o l d _ k s u _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ u n i t _ o l d _ k s u _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k s u _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ t y p e _ _ _ 0 2 C 7 6 9 E 9 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ t y p e _ _ _ 0 2 C 7 6 9 E 9 ]     D E F A U L T   ( ' ' )   F O R   [ t y p e _ s e r v e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ e x p l a n a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ e x p l a n a t i o n ]     D E F A U L T   ( ' ' )   F O R   [ e x p l a n a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ b a c k u _ _ 0 3 B B 8 E 2 2 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ b a c k u _ _ 0 3 B B 8 E 2 2 ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ f r e q u e n c y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ b a c k u _ _ 0 4 A F B 2 5 B ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ b a c k u _ _ 0 4 A F B 2 5 B ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ m e d i a ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ a u t o _ _ _ 0 5 A 3 D 6 9 4 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ a u t o _ _ _ 0 5 A 3 D 6 9 4 ]     D E F A U L T   ( ' ' )   F O R   [ a u t o _ m a n u a l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ o n s i t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ o n s i t e ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ o n s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ o f f s i t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ o f f s i t e ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ o f f s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ f r e q u _ _ 3 2 2 C 6 4 4 8 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ f r e q u _ _ 3 2 2 C 6 4 4 8 ]     D E F A U L T   ( ' ' )   F O R   [ f r e q u e n c y _ o f f s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ i t _ s e r v e r _ _ s u c c e _ _ 0 7 8 C 1 F 0 6 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ _ i t _ s e r v e r _ _ s u c c e _ _ 0 7 8 C 1 F 0 6 ]     D E F A U L T   ( ' ' )   F O R   [ s u c c e s s f u l _ r e c o v e r y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ a p p s _ i m p a c t e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ a p p s _ i m p a c t e d ]     D E F A U L T   ( ' ' )   F O R   [ a p p s _ i m p a c t e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ d e p t s _ i m p a c t e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ d e p t s _ i m p a c t e d ]     D E F A U L T   ( ' ' )   F O R   [ d e p t s _ i m p a c t e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ s e r v e r _ s o f t w a r e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ s e r v e r _ s o f t w a r e ]     D E F A U L T   ( ' ' )   F O R   [ s e r v e r _ s o f t w a r e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ t e c h ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ t e c h ]     D E F A U L T   ( ' ' )   F O R   [ t e c h ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ r e s p o n s i b l e _ p e r s o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ r e s p o n s i b l e _ p e r s o n ]     D E F A U L T   ( ' ' )   F O R   [ r e s p o n s i b l e _ p e r s o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ d i s k s _ d o c s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ l o c a t i o n _ d i s k s _ d o c s ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ d i s k s _ d o c s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s e r v e r s _ o l d _ i t _ s e r v e r _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s e r v e r s _ o l d _ i t _ s e r v e r _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ i t _ s e r v e r _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ P I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ P I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C r i t i c a l i t y L e v e l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C r i t i c a l i t y L e v e l ]     D E F A U L T   ( ' 0 ' )   F O R   [ C r i t i c a l i t y L e v e l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C e n t r a l A p p l i c a t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C e n t r a l A p p l i c a t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ C e n t r a l A p p l i c a t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ c e n t r a l _ a p p l i c a t i o n s _ C o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ C o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ f u n c t i o n a l _ o w n e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ f u n c t i o n a l _ o w n e r ]     D E F A U L T   ( ' ' )   F O R   [ f u n c t i o n a l _ o w n e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ t e c h n i c a l _ o w n e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ t e c h n i c a l _ o w n e r ]     D E F A U L T   ( ' ' )   F O R   [ t e c h n i c a l _ o w n e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n _ t y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n _ t y p e ]     D E F A U L T   ( ' ' )   F O R   [ a p p l i c a t i o n _ t y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ b a c k u p _ f r e q u e n c y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ b a c k u p _ f r e q u e n c y ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ f r e q u e n c y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ d i s k s _ d o c s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ d i s k s _ d o c s ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ d i s k s _ d o c s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ r e s p o n s i b l e _ p e r s o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ r e s p o n s i b l e _ p e r s o n ]     D E F A U L T   ( ' ' )   F O R   [ r e s p o n s i b l e _ p e r s o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ t e c h ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ t e c h ]     D E F A U L T   ( ' ' )   F O R   [ t e c h ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ d e p t s _ i m p a c t e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ d e p t s _ i m p a c t e d ]     D E F A U L T   ( ' ' )   F O R   [ d e p t s _ i m p a c t e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ c a m p u s _ s y s t e m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ c a m p u s _ s y s t e m s ]     D E F A U L T   ( ' ' )   F O R   [ c a m p u s _ s y s t e m s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ d a t a _ f r o m _ c o r e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ d a t a _ f r o m _ c o r e ]     D E F A U L T   ( ' ' )   F O R   [ d a t a _ f r o m _ c o r e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ t r a n s a c t i o n _ p r o c e s s i n g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ t r a n s a c t i o n _ p r o c e s s i n g ]     D E F A U L T   ( ' ' )   F O R   [ t r a n s a c t i o n _ p r o c e s s i n g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ b a c k u p _ m e d i a ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ b a c k u p _ m e d i a ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ m e d i a ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a u t o _ m a n u a l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a u t o _ m a n u a l ]     D E F A U L T   ( ' ' )   F O R   [ a u t o _ m a n u a l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ o n s i t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ o n s i t e ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ o n s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ o f f s i t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ l o c a t i o n _ o f f s i t e ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ o f f s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ f r e q u e n c y _ o f f s i t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ f r e q u e n c y _ o f f s i t e ]     D E F A U L T   ( ' ' )   F O R   [ f r e q u e n c y _ o f f s i t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ s u c c e s s f u l _ r e v o v e r y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ s u c c e s s f u l _ r e v o v e r y ]     D E F A U L T   ( ' ' )   F O R   [ s u c c e s s f u l _ r e c o v e r y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ s u c c e s s f u l _ r e c o v e r y _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ i t _ a p p l i c a t i o n s _ o l d _ i t _ a p p l i c a t i o n _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   A D D     C O N S T R A I N T   [ D F _ i t _ a p p l i c a t i o n s _ o l d _ i t _ a p p l i c a t i o n _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ i t _ a p p l i c a t i o n _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m s _ t e a m _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m s _ t e a m _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ t e a m _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m s _ t e a m _ p u r p o s e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m s _ t e a m _ p u r p o s e ]     D E F A U L T   ( ' ' )   F O R   [ t e a m _ p u r p o s e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ t e a m s _ t e a m _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ t e a m s _ t e a m _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ t e a m _ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ l o c a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ l o c a t i o n ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c o m m u n i c a t i o n _ o l d _ k _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c o m m u n i c a t i o n _ o l d _ k _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ u n i t _ h e a d s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ u n i t _ h e a d s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ u n i t _ h e a d s _ U s e r I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ u n i t _ h e a d s _ U s e r I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ U s e r I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ u n i t _ h e a d s _ U n i t H e a d C o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ u n i t _ h e a d s _ U n i t H e a d C o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ U n i t H e a d C o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ u n i t _ h e a d s _ C r e a t e d D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ u n i t _ h e a d s _ C r e a t e d D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ C r e a t e d D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ f i r s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ f i r s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ f i r s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ l a s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ l a s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ l a s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ d e p t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ d e p t ]     D E F A U L T   ( ' ' )   F O R   [ d e p t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ a d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ a d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ a d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ e m a i l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ e m a i l ]     D E F A U L T   ( ' ' )   F O R   [ e m a i l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ w o r k _ p h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ w o r k _ p h o n e ]     D E F A U L T   ( ' ' )   F O R   [ w o r k _ p h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ c e l l _ p h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ c e l l _ p h o n e ]     D E F A U L T   ( ' ' )   F O R   [ c e l l _ p h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ f a x ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ f a x ]     D E F A U L T   ( ' ' )   F O R   [ f a x ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ a l t e r n a t e _ v e n d o r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ a l t e r n a t e _ v e n d o r s ]     D E F A U L T   ( ' ' )   F O R   [ a l t e r n a t e _ v e n d o r s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ s t a k e h o l d e r _ t y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ s t a k e h o l d e r _ t y p e ]     D E F A U L T   ( ' 0 ' )   F O R   [ s t a k e h o l d e r _ t y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ p r o d u c t _ s e r v i c e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ p r o d u c t _ s e r v i c e ]     D E F A U L T   ( ' ' )   F O R   [ p r o d u c t _ s e r v i c e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a k e h o l d e r s _ o l d _ k s _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a k e h o l d e r s _ o l d _ k s _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k s _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ f i r s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ f i r s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ f i r s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ l a s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ l a s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ l a s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ d e p t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ d e p t ]     D E F A U L T   ( ' ' )   F O R   [ d e p t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ a d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ a d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ a d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ e m a i l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ e m a i l ]     D E F A U L T   ( ' ' )   F O R   [ e m a i l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ w o r k _ p h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ w o r k _ p h o n e ]     D E F A U L T   ( ' ' )   F O R   [ w o r k _ p h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ c e l l _ p h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ c e l l _ p h o n e ]     D E F A U L T   ( ' ' )   F O R   [ c e l l _ p h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ f a x ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ f a x ]     D E F A U L T   ( ' ' )   F O R   [ f a x ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ o l d _ k s o _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ s t a f f _ o t h e r _ u n i t s _ o l d _ k s o _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k s o _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ c i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ c i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ c i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ a c t i o n _ i t e _ _ t y p e _ _ 4 7 9 1 9 5 8 2 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ _ a c t i o n _ i t e _ _ t y p e _ _ 4 7 9 1 9 5 8 2 ]     D E F A U L T   ( ' ' )   F O R   [ a _ t y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ a c t i o n _ i t e _ _ n a m e _ _ 1 A 5 4 D A B 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ _ a c t i o n _ i t e _ _ n a m e _ _ 1 A 5 4 D A B 7 ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ c o s t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ c o s t ]     D E F A U L T   ( ' ' )   F O R   [ c o s t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ c o s t _ i s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ c o s t _ i s ]     D E F A U L T   ( ' ' )   F O R   [ c o s t _ i s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ s c o p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ s c o p e ]     D E F A U L T   ( ' ' )   F O R   [ s c o p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ s t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ s t a t u s ]     D E F A U L T   ( ' ' )   F O R   [ s t a t u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ a c t i o n _ i t e m s _ o l d _ a _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ D F _ a c t i o n _ i t e m s _ o l d _ a _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ a _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ p i s _ i d _ u n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   A D D     C O N S T R A I N T   [ p i s _ i d _ u n ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i s _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ C r i t i c a l i t y L e v e l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ C r i t i c a l i t y L e v e l ]     D E F A U L T   ( ' 0 ' )   F O R   [ C r i t i c a l i t y L e v e l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ p r i o r _ _ 0 5 8 E C 7 F B ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ p r i o r _ _ 0 5 8 E C 7 F B ]     D E F A U L T   ( ( 0 ) )   F O R   [ p r i o r i t y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ u n i t _ p e r f o r m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ u n i t _ p e r f o r m s ]     D E F A U L T   ( ' ' )   F O R   [ u n i t _ p e r f o r m s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ r e s p o n s i b l e _ p e r s o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ r e s p o n s i b l e _ p e r s o n ]     D E F A U L T   ( ' ' )   F O R   [ r e s p o n s i b l e _ p e r s o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j a n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j a n ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ j a n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ f e b ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ f e b ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ f e b ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ m a r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ m a r ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ m a r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ a p r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ a p r ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ a p r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ m a y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ m a y ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ m a y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j u n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j u n ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ j u n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j u l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ j u l ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ j u l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ a u g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ a u g ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ a u g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ s e p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ s e p ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ s e p ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ o c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ o c t ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ o c t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ n o v ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ n o v ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ n o v ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ d e c ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ p e a k _ d e c ]     D E F A U L T   ( ' N ' )   F O R   [ p e a k _ d e c ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ e x p l a n a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ e x p l a n a t i o n ]     D E F A U L T   ( ' ' )   F O R   [ e x p l a n a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s p a c e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s p a c e ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ s p a c e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ e q u i p m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ e q u i p m e n t ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ e q u i p m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s t a f f ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s t a f f ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ u n i q u e _ s k i l l s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ u n i q u e _ s k i l l s ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ u n i q u e _ s k i l l s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ w o r k _ a t _ h o m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ w o r k _ a t _ h o m e ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ w o r k _ a t _ h o m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ n e t w o r k _ a c c e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ n e t w o r k _ a c c e s s ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ n e t w o r k _ a c c e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s h o w _ s t o p p e r s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ s h o w _ s t o p p e r s ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ s h o w _ s t o p p e r s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ c a m p u s _ c l o s u r e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ c a m p u s _ c l o s u r e ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ c a m p u s _ c l o s u r e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ r i s k ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ r i s k ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ r i s k ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ p o l i c y _ e x c e p t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ p o l i c y _ e x c e p t i o n s ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ p o l i c y _ e x c e p t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ t i m i n g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ t i m i n g ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ t i m i n g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ a d d i t i o n a l _ v u l n e r a b i l i t i e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ h o w _ a d d i t i o n a l _ v u l n e r a b i l i t i e s ]     D E F A U L T   ( ' ' )   F O R   [ h o w _ a d d i t i o n a l _ v u l n e r a b i l i t i e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ d _ _ 3 8 B 9 6 6 4 6 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ d _ _ 3 8 B 9 6 6 4 6 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ d i s r u p t i o n _ t e a c h i n g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ t e a c h i n g _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ t e a c h i n g _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ d i s r u p t i o n _ t e a c h i n g _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ d _ _ 3 9 A D 8 A 7 F ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ d _ _ 3 9 A D 8 A 7 F ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ d i s r u p t i o n _ r e s e a r c h ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ r e s e a r c h _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ r e s e a r c h _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ d i s r u p t i o n _ r e s e a r c h _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 A A 1 A E B 8 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 A A 1 A E B 8 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l o s s _ f a c u l t y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ f a c u l t y _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ f a c u l t y _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l o s s _ f a c u l t y _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 B 9 5 D 2 F 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 B 9 5 D 2 F 1 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l o s s _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ s t a f f _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ s t a f f _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l o s s _ s t a f f _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 C 8 9 F 7 2 A ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 3 C 8 9 F 7 2 A ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l o s s _ s t u d e n t s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ s t u d e n t s _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ s t u d e n t s _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l o s s _ s t u d e n t s _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ w _ _ 3 D 7 E 1 B 6 3 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ w _ _ 3 D 7 E 1 B 6 3 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ w e l l _ b e i n g _ s t a f f ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ w e l l _ b e i n g _ s t a f f _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ w e l l _ b e i n g _ s t a f f _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ w e l l _ b e i n g _ s t a f f _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ w _ _ 3 E 7 2 3 F 9 C ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ w _ _ 3 E 7 2 3 F 9 C ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ w e l l _ b e i n g _ s t u d e n t s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ w e l l _ b e i n g _ s t u d e n t s _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ w e l l _ b e i n g _ s t u d e n t s _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ w e l l _ b e i n g _ s t u d e n t s _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ p _ _ 3 F 6 6 6 3 D 5 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ p _ _ 3 F 6 6 6 3 D 5 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ p a y m e n t _ d e a d l i n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ p a y m e n t _ d e a d l i n e _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ p a y m e n t _ d e a d l i n e _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ p a y m e n t _ d e a d l i n e _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 0 5 A 8 8 0 E ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 0 5 A 8 8 0 E ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l o s s _ r e v e n u e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ r e v e n u e _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l o s s _ r e v e n u e _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l o s s _ r e v e n u e _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 1 4 E A C 4 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 1 4 E A C 4 7 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l e g a l _ o b l i g a t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l e g a l _ o b l i g a t i o n s _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l e g a l _ o b l i g a t i o n s _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l e g a l _ o b l i g a t i o n s _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 2 4 2 D 0 8 0 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ l _ _ 4 2 4 2 D 0 8 0 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ l e g a l _ h a r m ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l e g a l _ h a r m _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ l e g a l _ h a r m _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ l e g a l _ h a r m _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ i _ _ 4 3 3 6 F 4 B 9 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ i _ _ 4 3 3 6 F 4 B 9 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ i m p a c t _ o t h e r _ c a m p u s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ i m p a c t _ o t h e r _ c a m p u s _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ i m p a c t _ o t h e r _ c a m p u s _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ i m p a c t _ o t h e r _ c a m p u s _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ i _ _ 4 4 2 B 1 8 F 2 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ i _ _ 4 4 2 B 1 8 F 2 ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ i m p a c t _ b u s i n e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ i m p a c t _ b u s i n e s s _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ i m p a c t _ b u s i n e s s _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ i m p a c t _ b u s i n e s s _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ c r i t i c a l _ _ _ c o n _ o _ _ 4 5 1 F 3 D 2 B ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ _ c r i t i c a l _ _ _ c o n _ o _ _ 4 5 1 F 3 D 2 B ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ o t h e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ o t h e r _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ o t h e r _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ o t h e r _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ p a t i e n t c a r e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ p a t i e n t c a r e ]     D E F A U L T   ( ' 0 ' )   F O R   [ c o n _ d i s r u p t i o n _ p a t i e n t c a r e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n ]     D E F A U L T   ( ' ' )   F O R   [ c o n _ d i s r u p t i o n _ p a t i e n t c a r e _ e x p l a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ d i s a b l e d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ d i s a b l e d ]     D E F A U L T   ( ' N ' )   F O R   [ d i s a b l e d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ c r i t i c a l _ f u n c t i o n s _ o l d _ c i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   A D D     C O N S T R A I N T   [ D F _ c r i t i c a l _ f u n c t i o n s _ o l d _ c i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ c i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ b u i l d i n g s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ b u i l d i n g s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ b u i l d i n g s _ B u i l d i n g I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ b u i l d i n g s _ B u i l d i n g I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ B u i l d i n g I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ b u i l d i n g s _ B u i l d i n g C o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ b u i l d i n g s _ B u i l d i n g C o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g C o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ P l a n n e r C a t e g o r y I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ P l a n n e r C a t e g o r y I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ P l a n n e r C a t e g o r y I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ N o t e 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ N o t e 1 ]     D E F A U L T   ( ' ' )   F O R   [ D e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ N o t e 2 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ N o t e 2 ]     D E F A U L T   ( ' ' )   F O R   [ N o t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ A l e r t F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ A l e r t F l a g ]     D E F A U L T   ( ' 0 ' )   F O R   [ A l e r t F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ A l e r t P e r i o d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ A l e r t P e r i o d ]     D E F A U L T   ( ' 1 ' )   F O R   [ A l e r t P e r i o d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ A l e r t L i s t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ A l e r t L i s t ]     D E F A U L T   ( ' ' )   F O R   [ A l e r t L i s t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r L o g _ C r e a t e D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r L o g _ C r e a t e D a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ C r e a t e D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ r e v i e w _ t y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ r e v i e w _ t y p e ]     D E F A U L T   ( ' A ' )   F O R   [ r e v i e w _ t y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ f i r s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ f i r s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ f i r s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ l a s t _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ l a s t _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ l a s t _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ r e v i e w _ d a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ r e v i e w _ d a t e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ r e v i e w _ d a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ h e a d _ o r _ d e s i g n e e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ h e a d _ o r _ d e s i g n e e ]     D E F A U L T   ( ' H ' )   F O R   [ h e a d _ o r _ d e s i g n e e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ e n t e r _ b y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ e n t e r _ b y ]     D E F A U L T   ( ( 0 ) )   F O R   [ e n t e r _ b y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ r e v i e w e r s _ e n t e r _ d a t e _ t i m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ r e v i e w e r s _ e n t e r _ d a t e _ t i m e ]     D E F A U L T   ( g e t d a t e ( ) )   F O R   [ e n t e r _ d a t e _ t i m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ d e p a r t m e n t _ t y p e s _ p i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ d e p a r t m e n t _ t y p e s _ p i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ p i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ p l a n _ d e p a r t m e n t _ t y p e s _ D e p a r t m e n t T y p e I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]   A D D     C O N S T R A I N T   [ D F _ p l a n _ d e p a r t m e n t _ t y p e s _ D e p a r t m e n t T y p e I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ D e p a r t m e n t T y p e I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ R e f e r e n c e _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ R e f e r e n c e ]   A D D     C O N S T R A I N T   [ D F _ R e f e r e n c e _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ R e f e r e n c e _ I t e m ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ R e f e r e n c e ]   A D D     C O N S T R A I N T   [ D F _ R e f e r e n c e _ I t e m ]     D E F A U L T   ( ' ' )   F O R   [ R e f e r e n c e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ R e f e r e n c e _ P r i o r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ R e f e r e n c e ]   A D D     C O N S T R A I N T   [ D F _ R e f e r e n c e _ P r i o r i t y ]     D E F A U L T   ( ( 1 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F A Q _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]   A D D     C O N S T R A I N T   [ D F _ F A Q _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F A Q _ Q u e s t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]   A D D     C O N S T R A I N T   [ D F _ F A Q _ Q u e s t i o n ]     D E F A U L T   ( ' ' )   F O R   [ Q u e s t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F A Q _ A n s w e r ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]   A D D     C O N S T R A I N T   [ D F _ F A Q _ A n s w e r ]     D E F A U L T   ( ' ' )   F O R   [ A n s w e r ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F A Q _ P r i o r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]   A D D     C O N S T R A I N T   [ D F _ F A Q _ P r i o r i t y ]     D E F A U L T   ( ( 1 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ C A A N ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ C A A N ]     D E F A U L T   ( ' ' )   F O R   [ C A A N ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ C o m m o n N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ C o m m o n N a m e ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g C o m m o n N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ A d d r e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ A d d r e s s ]     D E F A U L T   ( ' ' )   F O R   [ B u i l d i n g A d d r e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ B u i l d i n g _ O w n e d F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   A D D     C O N S T R A I N T   [ D F _ B u i l d i n g _ O w n e d F l a g ]     D E F A U L T   ( ' 1 ' )   F O R   [ O w n e r s h i p ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ T h i n g s T o K n o w _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ]   A D D     C O N S T R A I N T   [ D F _ T h i n g s T o K n o w _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ T h i n g s T o K n o w _ I t e m ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ]   A D D     C O N S T R A I N T   [ D F _ T h i n g s T o K n o w _ I t e m ]     D E F A U L T   ( ' ' )   F O R   [ T h i n g s T o K n o w I t e m ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ T h i n g s T o K n o w _ P r i o r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ]   A D D     C O N S T R A I N T   [ D F _ T h i n g s T o K n o w _ P r i o r i t y ]     D E F A U L T   ( ( 1 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p a r t m e n t T y p e _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p a r t m e n t T y p e ]   A D D     C O N S T R A I N T   [ D F _ D e p a r t m e n t T y p e _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p a r t m e n t T y p e _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p a r t m e n t T y p e ]   A D D     C O N S T R A I N T   [ D F _ D e p a r t m e n t T y p e _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r C a t e g o r y _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r C a t e g o r y _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r C a t e g o r y _ I t e m ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r C a t e g o r y _ I t e m ]     D E F A U L T   ( ' ' )   F O R   [ I t e m ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ P l a n n e r C a t e g o r y _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ P l a n n e r C a t e g o r y _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C e n t r a l A p p l i c a t i o n _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ C e n t r a l A p p l i c a t i o n _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C e n t r a l A p p l i c a t i o n _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ C e n t r a l A p p l i c a t i o n _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C e n t r a l A p p l i c a t i o n _ R e c o r d T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ C e n t r a l A p p l i c a t i o n _ R e c o r d T y p e ]     D E F A U L T   ( ' S ' )   F O R   [ R e c o r d T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C e n t r a l A p p l i c a t i o n _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]   A D D     C O N S T R A I N T   [ D F _ C e n t r a l A p p l i c a t i o n _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C o n t a c t U s _ I n s t i t u t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C o n t a c t U s ]   A D D     C O N S T R A I N T   [ D F _ C o n t a c t U s _ I n s t i t u t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C o n t a c t U s _ C o n t a c t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C o n t a c t U s ]   A D D     C O N S T R A I N T   [ D F _ C o n t a c t U s _ C o n t a c t ]     D E F A U L T   ( ' ' )   F O R   [ C o n t a c t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ C o n t a c t U s _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C o n t a c t U s ]   A D D     C O N S T R A I N T   [ D F _ C o n t a c t U s _ O r d e r N o ]     D E F A U L T   ( ( 1 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p e n d e n c y _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ D e p e n d e n c y _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p e n d e n c y _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ D e p e n d e n c y _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ D e p e n d e n c y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p e n d e n c y _ T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ D e p e n d e n c y _ T y p e ]     D E F A U L T   ( ' 1 ' )   F O R   [ D e p e n d e n c y T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p e n d e n c y _ R e c o r d T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ D e p e n d e n c y _ R e c o r d T y p e ]     D E F A U L T   ( ' S ' )   F O R   [ R e c o r d T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D e p e n d e n c y _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   A D D     C O N S T R A I N T   [ D F _ D e p e n d e n c y _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A n n u a l R e v i e w _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ]   A D D     C O N S T R A I N T   [ D F _ A n n u a l R e v i e w _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A n n u a l R e v i e w _ A n n u a l R e v i e w ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ]   A D D     C O N S T R A I N T   [ D F _ A n n u a l R e v i e w _ A n n u a l R e v i e w ]     D E F A U L T   ( ' ' )   F O R   [ R e v i e w I t e m ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A n n u a l R e v i e w _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ]   A D D     C O N S T R A I N T   [ D F _ A n n u a l R e v i e w _ O r d e r N o ]     D E F A U L T   ( ( 1 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A c r o n y m _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A c r o n y m ]   A D D     C O N S T R A I N T   [ D F _ A c r o n y m _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A c r o n y m _ A c r o n y m ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A c r o n y m ]   A D D     C O N S T R A I N T   [ D F _ A c r o n y m _ A c r o n y m ]     D E F A U L T   ( ' ' )   F O R   [ A c r o n y m ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ A c r o n y m _ F u l l N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A c r o n y m ]   A D D     C O N S T R A I N T   [ D F _ A c r o n y m _ F u l l N a m e ]     D E F A U L T   ( ' ' )   F O R   [ F u l l N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U t i l i t y _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ U t i l i t y _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U t i l i t y _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ U t i l i t y _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ U t i l i t y _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U t i l i t y ]   A D D     C O N S T R A I N T   [ D F _ U t i l i t y _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S t a f f C a t e g o r y _ I n s t i t u t i o n I d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ S t a f f C a t e g o r y _ I n s t i t u t i o n I d ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S t a f f C a t e g o r y _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ S t a f f C a t e g o r y _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ S t a f f C a t e g o r y ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S t a f f C a t e g o r y _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ]   A D D     C O N S T R A I N T   [ D F _ S t a f f C a t e g o r y _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F u n c t i o n E x a m p l e _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F u n c t i o n E x a m p l e ]   A D D     C O N S T R A I N T   [ D F _ F u n c t i o n E x a m p l e _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ F u n c t i o n E x a m p l e _ P l a n L i s t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F u n c t i o n E x a m p l e ]   A D D     C O N S T R A I N T   [ D F _ F u n c t i o n E x a m p l e _ P l a n L i s t ]     D E F A U L T   ( ' ' )   F O R   [ P l a n L i s t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S k i l l _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   A D D     C O N S T R A I N T   [ D F _ S k i l l _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S k i l l _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   A D D     C O N S T R A I N T   [ D F _ S k i l l _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S k i l l _ D e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   A D D     C O N S T R A I N T   [ D F _ S k i l l _ D e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ D e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S k i l l _ R e c o r d T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   A D D     C O N S T R A I N T   [ D F _ S k i l l _ R e c o r d T y p e ]     D E F A U L T   ( ' S ' )   F O R   [ R e c o r d T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S k i l l _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   A D D     C O N S T R A I N T   [ D F _ S k i l l _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D i v i s i o n _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ M a j o r D i v i s i o n ]   A D D     C O N S T R A I N T   [ D F _ D i v i s i o n _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ D i v i s i o n _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ M a j o r D i v i s i o n ]   A D D     C O N S T R A I N T   [ D F _ D i v i s i o n _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ M a j o r D i v i s i o n N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S h i f t _ I n s t i t u t i o n I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S h i f t ]   A D D     C O N S T R A I N T   [ D F _ S h i f t _ I n s t i t u t i o n I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ I n s t i t u t i o n I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S h i f t _ N a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S h i f t ]   A D D     C O N S T R A I N T   [ D F _ S h i f t _ N a m e ]     D E F A U L T   ( ' ' )   F O R   [ N a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S h i f t _ O r d e r N o ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S h i f t ]   A D D     C O N S T R A I N T   [ D F _ S h i f t _ O r d e r N o ]     D E F A U L T   ( ( 0 ) )   F O R   [ O r d e r N o ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n ]     D E F A U L T   ( ' ' )   F O R   [ I n s t i t u t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ I n s t i t i t i o n T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ I n s t i t i t i o n T y p e ]     D E F A U L T   ( ' 0 ' )   F O R   [ I n s t i t u t i o n T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n O r g L i s t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n O r g L i s t ]     D E F A U L T   ( ' ' )   F O R   [ I n s t i t u t i o n O r g L i s t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ A u t h L o c a t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ A u t h L o c a t i o n ]     D E F A U L T   ( ' ' )   F O R   [ A u t h L o c a t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ A u t h T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ A u t h T y p e ]     D E F A U L T   ( ' 1 ' )   F O R   [ A u t h T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ S h i b I d e n t i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ S h i b I d e n t i t y ]     D E F A U L T   ( ( 0 ) )   F O R   [ D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ N e w s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ N e w s ]     D E F A U L T   ( ' ' )   F O R   [ N e w s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ N e w s E x p i r a t i o n D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ N e w s E x p i r a t i o n D a t e ]     D E F A U L T   ( ( ( 1 ) / ( 1 ) ) / ( 2 0 0 0 ) )   F O R   [ N e w s E x p i r a t i o n D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ T i p s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ T i p s ]     D E F A U L T   ( ' ' )   F O R   [ T i p s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ T i p s E x p i r a t i o n D a t e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ T i p s E x p i r a t i o n D a t e ]     D E F A U L T   ( ( ( 1 ) / ( 1 ) ) / ( 2 0 0 0 ) )   F O R   [ T i p s E x p i r a t i o n D a t e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ P h o n e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ P h o n e ]     D E F A U L T   ( ' ' )   F O R   [ P h o n e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ F a x ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ F a x ]     D E F A U L T   ( ' ' )   F O R   [ F a x ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ E M a i l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ E M a i l ]     D E F A U L T   ( ' ' )   F O R   [ E M a i l ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n S t a t u s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ I n s t i t u t i o n S t a t u s ]     D E F A U L T   ( ' 2 ' )   F O R   [ I n s t i t u t i o n A c c e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ D i r e c t o r y A c c e s s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ D i r e c t o r y A c c e s s ]     D E F A U L T   ( ' 1 ' )   F O R   [ D i r e c t o r y A c c e s s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ T e a m s S c r e e n F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ T e a m s S c r e e n F l a g ]     D E F A U L T   ( ' 1 ' )   F O R   [ T e a m s S c r e e n F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ S k i l l s S c r e e n F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ S k i l l s S c r e e n F l a g ]     D E F A U L T   ( ' 1 ' )   F O R   [ S k i l l s S c r e e n F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ S t a f f i n g F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ S t a f f i n g F l a g ]     D E F A U L T   ( ' 1 ' )   F O R   [ S t a f f i n g S c r e e n F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ E x a m p l e s F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ E x a m p l e s F l a g ]     D E F A U L T   ( ' 1 ' )   F O R   [ E x a m p l e s S c r e e n F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ S y s t e m D o m a i n _ L B N L F l a g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ D F _ S y s t e m D o m a i n _ L B N L F l a g ]     D E F A U L T   ( ' 0 ' )   F O R   [ L B N L F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ R e p l a c e S t e p 4 F l a g _ u n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ R e p l a c e S t e p 4 F l a g _ u n ]     D E F A U L T   ( ' 0 ' )   F O R   [ R e p l a c e S t e p 4 F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ I n s t r u c t i o n _ U R L _ u n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     C O N S T R A I N T   [ I n s t r u c t i o n _ U R L _ u n ]     D E F A U L T   ( ' ' )   F O R   [ I n s t r u c t i o n _ U R L ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ _ S y s t e m D o m _ _ C r i t i _ _ 0 1 E 9 E A F 7 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   A D D     D E F A U L T   ( ' 0 ' )   F O R   [ C r i t i c a l L v l D t l s F l a g ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ c i d ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o w n e r _ d e p a r t m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o w n e r _ d e p a r t m e n t ]     D E F A U L T   ( ' ' )   F O R   [ o w n e r _ d e p a r t m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o r i g i n a l _ f i l e _ n a m e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o r i g i n a l _ f i l e _ n a m e ]     D E F A U L T   ( ' ' )   F O R   [ o r i g i n a l _ f i l e _ n a m e ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ l o c a t i o n _ k e p t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ l o c a t i o n _ k e p t ]     D E F A U L T   ( ' ' )   F O R   [ l o c a t i o n _ k e p t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c o m m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c o m m e n t ]     D E F A U L T   ( ' ' )   F O R   [ c o m m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ d e s c r i p t i o n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ d e s c r i p t i o n ]     D E F A U L T   ( ' ' )   F O R   [ d e s c r i p t i o n ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ m e d i u m I D ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ m e d i u m I D ]     D E F A U L T   ( ( 0 ) )   F O R   [ m e d i u m I D ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c o n t a c t s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c o n t a c t s ]     D E F A U L T   ( ' ' )   F O R   [ c o n t a c t s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ b a c k u p _ m e a s u r e s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ b a c k u p _ m e a s u r e s ]     D E F A U L T   ( ' ' )   F O R   [ b a c k u p _ m e a s u r e s ]  
 G O  
 / * * * * * *   O b j e c t :     D e f a u l t   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o l d _ k c d _ i d ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   A D D     C O N S T R A I N T   [ D F _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ o l d _ k c d _ i d ]     D E F A U L T   ( ( 0 ) )   F O R   [ o l d _ k c d _ i d ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ u t i l i t y _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ u t i l i t y _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ u t i l i t y _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ u t i l i t y _ U t i l i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ u t i l i t y _ U t i l i t y ]   F O R E I G N   K E Y ( [ U t i l i t y I D ] )  
 R E F E R E N C E S   [ d b o ] . [ U t i l i t y ]   ( [ U t i l i t y I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ u t i l i t y ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ u t i l i t y _ U t i l i t y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ t e a m _ m e m b e r s _ k e y _ t e a m s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ t e a m _ m e m b e r s _ k e y _ t e a m s ]   F O R E I G N   K E Y ( [ k t _ i d ] )  
 R E F E R E N C E S   [ d b o ] . [ k e y _ t e a m s ]   ( [ k t _ i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m _ m e m b e r s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ t e a m _ m e m b e r s _ k e y _ t e a m s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n s _ i n s t r u c t i o n s _ I n s t r u c t i o n a l D e p a r t m e n t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n s _ i n s t r u c t i o n s _ I n s t r u c t i o n a l D e p a r t m e n t ]   F O R E I G N   K E Y ( [ I n s t r u c t i o n a l D e p a r t m e n t I D ] )  
 R E F E R E N C E S   [ d b o ] . [ I n s t r u c t i o n a l D e p a r t m e n t ]   ( [ I n s t r u c t i o n a l D e p a r t m e n t I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n s _ i n s t r u c t i o n s _ I n s t r u c t i o n a l D e p a r t m e n t ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n s _ i n s t r u c t i o n s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n s _ i n s t r u c t i o n s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n s _ i n s t r u c t i o n s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ p l a n s _ i n s t r u c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ p l a n s _ i n s t r u c t i o n s ]   F O R E I G N   K E Y ( [ p i s _ i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   ( [ p i s _ i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s ]   C H E C K   C O N S T R A I N T   [ F K _ i n s t r u c t i o n _ t e a c h i n g _ i s s u e s _ p l a n s _ i n s t r u c t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ p l a n s _ i n s t r u c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ p l a n s _ i n s t r u c t i o n s ]   F O R E I G N   K E Y ( [ p i s _ i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s _ i n s t r u c t i o n s ]   ( [ p i s _ i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ i n s t r u c t i o n _ h i g h _ p r i o r i t y ]   C H E C K   C O N S T R A I N T   [ F K _ i n s t r u c t i o n _ h i g h _ p r i o r i t y _ p l a n s _ i n s t r u c t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ c f _ d e p e n d e n c y _ D e p e n d e n c y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ c f _ d e p e n d e n c y _ D e p e n d e n c y ]   F O R E I G N   K E Y ( [ D e p e n d e n c y I D ] )  
 R E F E R E N C E S   [ d b o ] . [ D e p e n d e n c y ]   ( [ D e p e n d e n c y I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]   C H E C K   C O N S T R A I N T   [ F K _ c f _ d e p e n d e n c y _ D e p e n d e n c y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ c f _ d o w n s t r e a m _ d e p e n d e n c y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ c f _ d o w n s t r e a m _ d e p e n d e n c y ]   F O R E I G N   K E Y ( [ c i d ] )  
 R E F E R E N C E S   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   ( [ c i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ c f _ d e p e n d e n c y ]   C H E C K   C O N S T R A I N T   [ F K _ c f _ d o w n s t r e a m _ d e p e n d e n c y _ c f _ d o w n s t r e a m _ d e p e n d e n c y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s k i l l s _ S k i l l ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s k i l l s _ S k i l l ]   F O R E I G N   K E Y ( [ S k i l l I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S k i l l ]   ( [ S k i l l I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s k i l l s _ S k i l l ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k s _ i d _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k s _ i d _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s k i l l s ]   C H E C K   C O N S T R A I N T   [ F K _ k s _ i d _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a f f i n g _ r e q _ c r i t i c a l _ f u n c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ c r i t i c a l _ f u n c t i o n s ]   F O R E I G N   K E Y ( [ c i d ] )  
 R E F E R E N C E S   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   ( [ c i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ c r i t i c a l _ f u n c t i o n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a f f i n g _ r e q _ S h i f t ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ S h i f t ]   F O R E I G N   K E Y ( [ S h i f t I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S h i f t ]   ( [ S h i f t I D ] )  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ S h i f t ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a f f i n g _ r e q _ S t a f f C a t e g o r y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ S t a f f C a t e g o r y ]   F O R E I G N   K E Y ( [ S t a f f C a t e g o r y I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S t a f f C a t e g o r y ]   ( [ S t a f f C a t e g o r y I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f i n g _ r e q ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a f f i n g _ r e q _ S t a f f C a t e g o r y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ w o r k _ h o m e _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]     W I T H   N O C H E C K   A D D     C O N S T R A I N T   [ F K _ w o r k _ h o m e _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ w o r k _ h o m e ]   C H E C K   C O N S T R A I N T   [ F K _ w o r k _ h o m e _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ u s e r _ p l a n _ p l a n s 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ u s e r _ p l a n _ p l a n s 1 ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   C H E C K   C O N S T R A I N T   [ F K _ u s e r _ p l a n _ p l a n s 1 ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ u s e r _ p l a n _ U s e r S e c u r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ u s e r _ p l a n _ U s e r S e c u r i t y ]   F O R E I G N   K E Y ( [ U s e r I D ] )  
 R E F E R E N C E S   [ d b o ] . [ U s e r S e c u r i t y ]   ( [ U s e r I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ u s e r _ p l a n ]   C H E C K   C O N S T R A I N T   [ F K _ u s e r _ p l a n _ U s e r S e c u r i t y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ p l a n _ d o c u m e n t s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ p l a n _ d o c u m e n t s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ p l a n _ d o c u m e n t s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ p l a n _ d o c u m e n t s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ c o n t a c t s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ c o n t a c t s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ c o n t a c t s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ c o n t a c t s _ U s e r S e c u r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ c o n t a c t s _ U s e r S e c u r i t y ]   F O R E I G N   K E Y ( [ U s e r I D ] )  
 R E F E R E N C E S   [ d b o ] . [ U s e r S e c u r i t y ]   ( [ U s e r I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ c o n t a c t s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ c o n t a c t s _ U s e r S e c u r i t y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a f f _ u n i t _ p l a n s 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a f f _ u n i t _ p l a n s 1 ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ u n i t ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a f f _ u n i t _ p l a n s 1 ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ i t _ s e r v e r s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ i t _ s e r v e r s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ i t _ s e r v e r s ]   C H E C K   C O N S T R A I N T   [ F K _ i t _ s e r v e r s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ i t _ c e n t r a l _ a p p l i c a t i o n s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ i t _ c e n t r a l _ a p p l i c a t i o n s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ i t _ c e n t r a l _ a p p l i c a t i o n s ]   C H E C K   C O N S T R A I N T   [ F K _ i t _ c e n t r a l _ a p p l i c a t i o n s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ i t _ a p p l i c a t i o n s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ i t _ a p p l i c a t i o n s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ i t _ a p p l i c a t i o n s ]   C H E C K   C O N S T R A I N T   [ F K _ i t _ a p p l i c a t i o n s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ t e a m s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ t e a m s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ t e a m s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ t e a m s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ c o m m u n i c a t i o n _ p l a n s 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ c o m m u n i c a t i o n _ p l a n s 1 ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c o m m u n i c a t i o n ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ c o m m u n i c a t i o n _ p l a n s 1 ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ u n i t _ h e a d s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ u n i t _ h e a d s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ u n i t _ h e a d s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ u n i t _ h e a d s _ U s e r S e c u r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ u n i t _ h e a d s _ U s e r S e c u r i t y ]   F O R E I G N   K E Y ( [ U s e r I D ] )  
 R E F E R E N C E S   [ d b o ] . [ U s e r S e c u r i t y ]   ( [ U s e r I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ u n i t _ h e a d s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ u n i t _ h e a d s _ U s e r S e c u r i t y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a k e h o l d e r s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a k e h o l d e r s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a k e h o l d e r s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a k e h o l d e r s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ s t a f f _ o t h e r _ u n i t s _ p l a n s 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ s t a f f _ o t h e r _ u n i t s _ p l a n s 1 ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ s t a f f _ o t h e r _ u n i t s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ s t a f f _ o t h e r _ u n i t s _ p l a n s 1 ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ a c t i o n _ i t e m s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ a c t i o n _ i t e m s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ a c t i o n _ i t e m s ]   C H E C K   C O N S T R A I N T   [ F K _ a c t i o n _ i t e m s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ c r i t i c a l _ f u n c t i o n s _ p l a n s 1 ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ c r i t i c a l _ f u n c t i o n s _ p l a n s 1 ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   C H E C K   C O N S T R A I N T   [ F K _ c r i t i c a l _ f u n c t i o n s _ p l a n s 1 ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ b u i l d i n g s _ B u i l d i n g ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ b u i l d i n g s _ B u i l d i n g ]   F O R E I G N   K E Y ( [ B u i l d i n g I D ] )  
 R E F E R E N C E S   [ d b o ] . [ B u i l d i n g ]   ( [ B u i l d i n g I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ b u i l d i n g s _ B u i l d i n g ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ b u i l d i n g s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ b u i l d i n g s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ b u i l d i n g s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ b u i l d i n g s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ P l a n n e r L o g _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ P l a n n e r L o g _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r L o g ]   C H E C K   C O N S T R A I N T   [ F K _ P l a n n e r L o g _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ r e v i e w e r s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ r e v i e w e r s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ r e v i e w e r s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ r e v i e w e r s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ D e p a r t m e n t T y p e ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ D e p a r t m e n t T y p e ]   F O R E I G N   K E Y ( [ D e p a r t m e n t T y p e I D ] )  
 R E F E R E N C E S   [ d b o ] . [ D e p a r t m e n t T y p e ]   ( [ D e p a r t m e n t T y p e I d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ D e p a r t m e n t T y p e ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ p l a n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ p l a n s ]   F O R E I G N   K E Y ( [ p i d ] )  
 R E F E R E N C E S   [ d b o ] . [ p l a n s ]   ( [ p i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ p l a n _ d e p a r t m e n t _ t y p e s ]   C H E C K   C O N S T R A I N T   [ F K _ p l a n _ d e p a r t m e n t _ t y p e s _ p l a n s ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ R e f e r e n c e _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ R e f e r e n c e ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ R e f e r e n c e _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ R e f e r e n c e ]   C H E C K   C O N S T R A I N T   [ F K _ R e f e r e n c e _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ F A Q _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ F A Q _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ F A Q ]   C H E C K   C O N S T R A I N T   [ F K _ F A Q _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S y s t e m D o m a i n U I I m a g e _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I I m a g e ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S y s t e m D o m a i n U I I m a g e _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I I m a g e ]   C H E C K   C O N S T R A I N T   [ F K _ S y s t e m D o m a i n U I I m a g e _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S y s t e m D o m a i n U I T e x t _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I T e x t ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S y s t e m D o m a i n U I T e x t _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n U I T e x t ]   C H E C K   C O N S T R A I N T   [ F K _ S y s t e m D o m a i n U I T e x t _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ B u i l d i n g _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ B u i l d i n g _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ B u i l d i n g ]   C H E C K   C O N S T R A I N T   [ F K _ B u i l d i n g _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ N e t D o m a i n _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ N e t D o m a i n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ N e t D o m a i n _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ N e t D o m a i n ]   C H E C K   C O N S T R A I N T   [ F K _ N e t D o m a i n _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c ]   C H E C K   C O N S T R A I N T   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l F u n c _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l ]   C H E C K   C O N S T R A I N T   [ F K _ S y s t e m D o m a i n C r i t i c a l L e v e l A p p l _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ T h i n g s T o K n o w _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ T h i n g s T o K n o w _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ T h i n g s T o K n o w ]   C H E C K   C O N S T R A I N T   [ F K _ T h i n g s T o K n o w _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ D e p a r t m e n t T y p e _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p a r t m e n t T y p e ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ D e p a r t m e n t T y p e _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ D e p a r t m e n t T y p e ]   C H E C K   C O N S T R A I N T   [ F K _ D e p a r t m e n t T y p e _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ P l a n n e r C a t e g o r y _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ P l a n n e r C a t e g o r y _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ P l a n n e r C a t e g o r y ]   C H E C K   C O N S T R A I N T   [ F K _ P l a n n e r C a t e g o r y _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ C e n t r a l A p p l i c a t i o n _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ C e n t r a l A p p l i c a t i o n _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ C e n t r a l A p p l i c a t i o n ]   C H E C K   C O N S T R A I N T   [ F K _ C e n t r a l A p p l i c a t i o n _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ C o n t a c t U s _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ C o n t a c t U s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ C o n t a c t U s _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ C o n t a c t U s ]   C H E C K   C O N S T R A I N T   [ F K _ C o n t a c t U s _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ D e p e n d e n c y _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ D e p e n d e n c y _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ D e p e n d e n c y ]   C H E C K   C O N S T R A I N T   [ F K _ D e p e n d e n c y _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ A n n u a l R e v i e w _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ A n n u a l R e v i e w _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ A n n u a l R e v i e w ]   C H E C K   C O N S T R A I N T   [ F K _ A n n u a l R e v i e w _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ A c r o n y m _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A c r o n y m ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ A c r o n y m _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ A c r o n y m ]   C H E C K   C O N S T R A I N T   [ F K _ A c r o n y m _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ U t i l i t y _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ U t i l i t y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ U t i l i t y _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ U t i l i t y ]   C H E C K   C O N S T R A I N T   [ F K _ U t i l i t y _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S t a f f C a t e g o r y _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S t a f f C a t e g o r y _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I d ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S t a f f C a t e g o r y ]   C H E C K   C O N S T R A I N T   [ F K _ S t a f f C a t e g o r y _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ F u n c t i o n E x a m p l e _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ F u n c t i o n E x a m p l e ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ F u n c t i o n E x a m p l e _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ F u n c t i o n E x a m p l e ]   C H E C K   C O N S T R A I N T   [ F K _ F u n c t i o n E x a m p l e _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S k i l l _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S k i l l _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S k i l l ]   C H E C K   C O N S T R A I N T   [ F K _ S k i l l _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ M a j o r D i v i s i o n _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ M a j o r D i v i s i o n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ M a j o r D i v i s i o n _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ M a j o r D i v i s i o n ]   C H E C K   C O N S T R A I N T   [ F K _ M a j o r D i v i s i o n _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S h i f t _ S y s t e m D o m a i n ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S h i f t ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S h i f t _ S y s t e m D o m a i n ]   F O R E I G N   K E Y ( [ I n s t i t u t i o n I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n ]   ( [ I n s t i t u t i o n I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S h i f t ]   C H E C K   C O N S T R A I N T   [ F K _ S h i f t _ S y s t e m D o m a i n ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ S y s t e m D o m a i n _ S y s t e m D o m a i n G r o u p ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ S y s t e m D o m a i n _ S y s t e m D o m a i n G r o u p ]   F O R E I G N   K E Y ( [ I n s t G r o u p I D ] )  
 R E F E R E N C E S   [ d b o ] . [ S y s t e m D o m a i n G r o u p ]   ( [ I n s t G r o u p I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   S E T   N U L L  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ S y s t e m D o m a i n ]   C H E C K   C O N S T R A I N T   [ F K _ S y s t e m D o m a i n _ S y s t e m D o m a i n G r o u p ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ A d m i n T e s t M o d e _ U s e r S e c u r i t y ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ A d m i n T e s t M o d e ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ A d m i n T e s t M o d e _ U s e r S e c u r i t y ]   F O R E I G N   K E Y ( [ U s e r I D ] )  
 R E F E R E N C E S   [ d b o ] . [ U s e r S e c u r i t y ]   ( [ U s e r I D ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ A d m i n T e s t M o d e ]   C H E C K   C O N S T R A I N T   [ F K _ A d m i n T e s t M o d e _ U s e r S e c u r i t y ]  
 G O  
 / * * * * * *   O b j e c t :     F o r e i g n K e y   [ F K _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c r i t i c a l _ f u n c t i o n s ]         S c r i p t   D a t e :   0 5 / 2 0 / 2 0 1 1   1 4 : 4 1 : 3 2   * * * * * * /  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]     W I T H   C H E C K   A D D     C O N S T R A I N T   [ F K _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c r i t i c a l _ f u n c t i o n s ]   F O R E I G N   K E Y ( [ c i d ] )  
 R E F E R E N C E S   [ d b o ] . [ c r i t i c a l _ f u n c t i o n s ]   ( [ c i d ] )  
 O N   U P D A T E   C A S C A D E  
 O N   D E L E T E   C A S C A D E  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s ]   C H E C K   C O N S T R A I N T   [ F K _ k e y _ c r i t i c a l _ f u n c t i o n _ d o c u m e n t s _ c r i t i c a l _ f u n c t i o n s ]  
 G O  
 