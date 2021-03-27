%% THE MULTI-OBJECTIVE FUNCTION
function y=simpleMultiObj(x)
  % HERE BOTH x and y ARE VECTORS
  y(1)=(x+2)^2-10;
  y(2)=(x-2)^2+20;
end